package com.lemonhexa.web.templates;

import com.lemonhexa.web.helper.wrapper.ToolbarWrapper;
import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.util.Clients;

/**
 *
 * @author maikel
 */
public abstract class Toolbar {
    
//    private ToolbarWrapper addState;
    private ToolbarWrapper delState;
    private ToolbarWrapper saveState;
    private ToolbarWrapper cancelState;
    private ToolbarWrapper browseState;
//    private ToolbarWrapper infoState; 
    
    public void init() {        
//        setAddState(new ToolbarWrapper(false, false));
        setDelState(new ToolbarWrapper(false, false));
        setSaveState(new ToolbarWrapper(false, false));
        setCancelState(new ToolbarWrapper(false, false));
        setBrowseState(new ToolbarWrapper(false, false));        
//        setInfoState(new ToolbarWrapper(true, false));
        btnStateNormal();
    }

    // toolbar command    
    private void btnStateNormal() {
//        getAddState().setState(true, false);
        getDelState().setState(false, true);
        getSaveState().setState(true, false);
        getCancelState().setState(false, true);
        getBrowseState().setState(true, false);        
//        getInfoState().setState(true, false);
        notifyToolbar();
    }

//    private void btnStateNew() {
//        getAddState().setState(false, true);
//        getDelState().setState(false, true);
//        getSaveState().setState(true, false);
//        getCancelState().setState(true, false);
//        getBrowseState().setState(false, true);        
//        getInfoState().setState(true, false);
//        notifyToolbar();
//    }

    private void btnStateEdit() {
//        getAddState().setState(false, true);
        getDelState().setState(true, false);
        getSaveState().setState(true, false);
        getCancelState().setState(true, false);
        getBrowseState().setState(false, true);        
//        getInfoState().setState(true, false);
        notifyToolbar();
    }

    private void notifyToolbar() {
        BindUtils.postNotifyChange(null, null, this, "addState");
        BindUtils.postNotifyChange(null, null, this, "delState");
        BindUtils.postNotifyChange(null, null, this, "saveState");
        BindUtils.postNotifyChange(null, null, this, "cancelState");
        BindUtils.postNotifyChange(null, null, this, "browseState");
        BindUtils.postNotifyChange(null, null, this, "refreshState");
        BindUtils.postNotifyChange(null, null, this, "infoState");
    }
    
//    public void addClick() {
//        btnStateNew();
//    }

    public void editClick() {
        btnStateEdit();
    }

    public void deleteClick() {
        btnStateNormal();
    }

    public void saveClick() {
        btnStateNormal();
    }

    public void cancelClick() {
        btnStateNormal();
    }
    
    public void browseClick() {           
        Clients.showNotification("Browse apaan masbro!!?");      
    }

    public void infoClick() {
        Clients.showNotification("Yuhuu!!");
    }

    // ------------ SETTER & GETTER ---------------------------
//    public ToolbarWrapper getAddState() {
//        return addState;
//    }
//
//    public void setAddState(ToolbarWrapper addState) {
//        this.addState = addState;
//    }

    public ToolbarWrapper getDelState() {
        return delState;
    }

    public void setDelState(ToolbarWrapper delState) {
        this.delState = delState;
    }

    public ToolbarWrapper getSaveState() {
        return saveState;
    }

    public void setSaveState(ToolbarWrapper saveState) {
        this.saveState = saveState;
    }

    public ToolbarWrapper getCancelState() {
        return cancelState;
    }

    public void setCancelState(ToolbarWrapper cancelState) {
        this.cancelState = cancelState;
    }

    public ToolbarWrapper getBrowseState() {
        return browseState;
    }

    public void setBrowseState(ToolbarWrapper browseState) {
        this.browseState = browseState;
    }

//    public ToolbarWrapper getInfoState() {
//        return infoState;
//    }
//    
//    public void setInfoState(ToolbarWrapper infoState) {    
//        this.infoState = infoState;
//    }
}
