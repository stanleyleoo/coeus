/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.route;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

/**
 *
 * @author Ploychompoo
 */
public class ZkRouter {
	private Map<String, ZkRoute> routesWithoutParams = new TreeMap<String, ZkRoute>();
	private Map<String, ZkRoute> routesWithParams = new TreeMap<String, ZkRoute>();
	private Component contentHolder = null;
	private Component content = null;

	public ZkRouter(Map<String, ZkRoute> routesWithoutParams, Map<String, ZkRoute> routesWithParams) {
		this.routesWithoutParams = routesWithoutParams;
		this.routesWithParams = routesWithParams;
	}

	private String removeFirstAndLastSlash(String url) {
		url = url.replaceAll("^/", "");
		url = url.replaceAll("/$", "");
		return url;
	}

	public void setContentHolder(Component contentHolder) {
		this.contentHolder = contentHolder;
	}

	public Component getContentHolder() {
		return contentHolder;
	}

	public void dispatch(String url) {
		url = removeFirstAndLastSlash(url);
		
		ZkRoute route = findRoute(url);
		if (route == null) {
			return;
		} else {			
			Map<String, Object> pathVariables = new HashMap<String, Object>();
			try {
				pathVariables = route.resolvePathVariables(url);
			} catch (RuntimeException e) {
				return;
			}
			
			if (content != null) {
				content.detach();
				content = null;
			}
			content = Executions.createComponents(route.getView(), contentHolder, pathVariables);
		}
	}

	private ZkRoute findRoute(String url) {
		for (String testUrl : routesWithoutParams.keySet()) {
			ZkRoute route = routesWithoutParams.get(testUrl);
			if (route.matches(url)) {
				return route;
			}
		}

		for (String testUrl : routesWithParams.keySet()) {
			ZkRoute route = routesWithParams.get(testUrl);
			if (route.matches(url)) {
				return route;
			}
		}

		return null;
	}
	
	public void goTo(String url) {
		url = url.replaceAll("#", "");
		Clients.evalJavaScript("window.location.hash = '#" + url + "';");
	}
	
	public static ZkRouter getCurrent() {
		Execution execution = Executions.getCurrent();
		if(execution != null && execution.getDesktop() != null) {
			Object router = execution.getDesktop().getAttribute("router");
			if(router != null && router instanceof ZkRouter) {
				return (ZkRouter) router;
			}
		}
		return null;
	}    
}
