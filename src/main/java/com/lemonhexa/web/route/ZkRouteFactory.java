/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.route;

import java.util.TreeMap;
import java.util.Map;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author Ploychompoo
 */
public class ZkRouteFactory {
        private Map<String, ZkRoute> routesWithoutParams = new TreeMap<String, ZkRoute>();
	private Map<String, ZkRoute> routesWithParams = new TreeMap<String, ZkRoute>();
	
	public ZkRoute addRoute(String url, String view) {
		url = url.toLowerCase();
		url = removeFirstAndLastSlash(url);
		ZkRoute route = new ZkRoute(url, view);
		if (url.contains("{")) {
			routesWithParams.put(url, route);
		} else {
			routesWithoutParams.put(url, route);
		}
		return route;
	}

	private String removeFirstAndLastSlash(String url) {
		url = url.replaceAll("^/", "");
		url = url.replaceAll("/$", "");
		return url;
	}
	
	public ZkRouter createRouter(Component contentHolder) {
		ZkRouter router = new ZkRouter(routesWithoutParams, routesWithParams);
		router.setContentHolder(contentHolder);
		Executions.getCurrent().getDesktop().setAttribute("router", router);
		return router;
	}    
    
}
