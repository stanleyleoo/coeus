/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.ui.web;

import com.lemonhexa.web.entity.Salesgroup;
import com.lemonhexa.web.helper.AppUtil;
import com.lemonhexa.web.templates.Toolbar;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

/**
 *
 * @author Ploychompoo
 */
public class SalesGroupVm extends Toolbar{
    
    private Salesgroup selected;
    private List<Salesgroup> lists;
    Integer recordVersion = 0;
    
    public SalesGroupVm(){
        
    }
    
    @Init()
    @NotifyChange({"selected"})
    public void Init() {
        super.init();
        setSelected(new Salesgroup());
    }
    
    @Command
    @Override
    @NotifyChange({"selected"})
    public void editClick() {
        super.editClick();
    }

    @Command
    @Override
    @NotifyChange({"selected"})
    public void deleteClick() {
        if (getSelected() != null) {
            try {
                if(AppUtil.getWebService().delete(getSelected())){
                    setSelected(null);
                    super.deleteClick();
                    Clients.showNotification("Delete successful.");
                }
            } catch (Exception e) {
                Clients.showNotification("Delete failed.\n" + e.getLocalizedMessage());
            }
        } else {
            Clients.showNotification("Record not found.");
        }
    }

    @Command
    @Override
    @NotifyChange({"selected"})
    public void saveClick() {  
        try {    
            if(getSelected().getRecordId() == null){
                if(getSelected() != null){
                    getSelected().setRecordVersion(recordVersion);
                }else{
                    System.out.println("gak tau");
                }
            }else{
                recordVersion++;
                getSelected().setRecordVersion(recordVersion);
            }
            
            if(AppUtil.getWebService().save(getSelected())) {
                setSelected(new Salesgroup());
                super.saveClick();
                Clients.showNotification("Save successful.");
            }
        } catch (Exception e) {
            Clients.showNotification("Save failed.\n" + e.getLocalizedMessage());
        }
    }

    @Command
    @Override
    @NotifyChange({"selected"})
    public void cancelClick() {
        setSelected(null);
        super.cancelClick();
    }
    
    @Command
    @Override
    @NotifyChange({"selected"})
    public void browseClick() {
        Executions.createComponents("/Component/salesGroupBrowseData.zul", null, null);
    }

    @GlobalCommand
    @NotifyChange({"selected"})
    public void browseSelected(@BindingParam("salesGroupSelected") Salesgroup salesGroupSelected) {
        if (salesGroupSelected != null) {
            setSelected(salesGroupSelected);
            System.out.println("select");
            super.editClick();
        }else{
            System.out.println("null");
        }
    }

    public Salesgroup getSelected() {
        return selected;
    }

    public void setSelected(Salesgroup selected) {
        this.selected = selected;
    }

    public List<Salesgroup> getLists() {
        return lists;
    }

    public void setLists(List<Salesgroup> lists) {
        this.lists = lists;
    }

    public Integer getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }
    
}
