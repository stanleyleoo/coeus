/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.templates;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.ListModelList;

/**
 *
 * @author Stanley
 */
public class sidebarComposer extends SelectorComposer<Component>{
    ListModelList<TabInfo> tabsModel;
    private TabInfo selected;
    private int selectedIndex = 0;
    @Wire
    Hlayout main;
    @Wire
    Div sidebar;
    @Wire
    Navbar navbar;
    @Wire
    Navitem calitem;
    @Wire
    A toggler;

    public sidebarComposer() {

    }
    @Init
    public void init() {
        tabsModel = new ListModelList<>();
        tabsModel.add(selected = new TabInfo("dashboard", "dashboard.zul"));
        
    }
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
    }

    // Toggle sidebar to collapse or expand
    @Listen("onClick = #toggler")
    public void toggleSidebarCollapsed() {
        if (navbar.isCollapsed()) {
            sidebar.setSclass("sidebar");
            navbar.setCollapsed(false);
            calitem.setTooltip("calpp, position=end_center, delay=0");
            toggler.setIconSclass("z-icon-angle-double-left");
        } else {
            sidebar.setSclass("sidebar sidebar-min");
            navbar.setCollapsed(true);
            calitem.setTooltip("");
            toggler.setIconSclass("z-icon-angle-double-right");
        }
        // Force the hlayout contains sidebar to recalculate its size
        Clients.resize(sidebar.getRoot().query("#main"));
    }

    @Command
    @NotifyChange({"tabsModel"})
    public void addTab(@BindingParam("tabName") String name, @BindingParam("tabPath") String path) {
        selected = new TabInfo(name, path);
        tabsModel.add(selected);
        tabsModel.addToSelection(selected);
        
    }
    
    @Command
    @NotifyChange({"tabsModel"})
    public void closeTab(@BindingParam("tabToClose") TabInfo tabToClose) {
	tabsModel.remove(tabToClose);
    }

    public ListModelList<TabInfo> getTabsModel() {
        return tabsModel;
    }

    public TabInfo getSelected() {
        return selected;
    }

    public void setSelected(TabInfo selected) {
        this.selected = selected;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public static class TabInfo {

        String path;
        String title;

        public TabInfo(String title, String path) {
            super();
            this.title = title;
            this.path = path;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
