/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.component.filter;

/**
 *
 * @author Ploychompoo
 */
public class SalesGroupFilter {
    
    private String groupCode = "", groupName = "";
    
    public SalesGroupFilter(){
        
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
}
