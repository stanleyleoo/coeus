/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.ui.web;

import com.lemonhexa.web.entity.Geodata;
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
public class GeodataVm extends Toolbar{
    private Geodata selected;
    private List<Geodata> lists;
    Integer globalRecordId = 1;
    Integer recordVersion = 0;
    
    public GeodataVm(){
        
    }
    
    @Init()
    public void Init() {
        super.init();
    }
    
    @Command
    @Override
    @NotifyChange({"selected"})
    public void addClick() {
        super.addClick();
        setSelected(new Geodata());
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
                    getSelected().setGlobalRecordId("A00" + globalRecordId);
                    getSelected().setRecordVersion(recordVersion);
                    globalRecordId++;
                }else{
                    System.out.println("gak tau");
                }
            }else{
                recordVersion++;
                getSelected().setRecordVersion(recordVersion);
            }
            
            if(AppUtil.getWebService().save(getSelected())) {
                setSelected(null);
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
        Executions.createComponents("/Component/geodataBrowseData.zul", null, null);
    }

    @GlobalCommand
    @NotifyChange({"selected"})
    public void browseSelected(@BindingParam("geodataSelected") Geodata geodataSelected) {
        if (geodataSelected != null) {
            setSelected(geodataSelected);
            System.out.println("work fine");
            super.editClick();
        }
    }
    
    public Geodata getSelected() {
        return selected;
    }

    public void setSelected(Geodata selected) {
        this.selected = selected;
    }

    public List<Geodata> getLists() {
        return lists;
    }

    public void setLists(List<Geodata> lists) {
        this.lists = lists;
    }
    
}
