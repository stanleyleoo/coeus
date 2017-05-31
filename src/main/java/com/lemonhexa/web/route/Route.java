/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.route;
/**
 *
 * @author Ploychompoo
 */
import static com.sun.corba.se.impl.util.RepositoryId.cache;
import java.util.HashMap;
import java.util.Map;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

public class Route {
    private ZkRouteFactory routerFactory;
    private ZkRouter router;
  
  	@Init
        public void init() {
                routerFactory = new ZkRouteFactory();
                routerFactory.addRoute("/hello", "hello.zul");
        }
  
        @AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Component contentHolder = view.getFirstChild();
		router = routerFactory.createRouter(contentHolder);
		Clients.showBusy(contentHolder, "Loading...");
        }
        
        @Command
        public void go(){
            Map arg = new HashMap();
            arg.put("hello", "hello.zul");
            Component[] comps = Executions.getCurrent().createComponents("index.zul", arg); //won't be attached to a page
            cache.put("pool", comps);
        }
	
	@Command
	public void goToDefaultRoute() {
		router.goTo("/");
	}

	@Command
	public void onHashChange(@BindingParam("url") String url) {
		Clients.clearBusy(router.getContentHolder());
		router.dispatch(url);
	}
}
