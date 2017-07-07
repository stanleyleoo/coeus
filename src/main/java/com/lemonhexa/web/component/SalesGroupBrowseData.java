/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.component;

import com.lemonhexa.web.component.filter.SalesGroupFilter;
import com.lemonhexa.web.entity.Salesgroup;
import com.lemonhexa.web.helper.AppUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

/**
 *
 * @author Ploychompoo
 */
public class SalesGroupBrowseData {
    
    private final Integer[] sizeData = {5, 10, 20, 50, 100};
    private ListModelList<Salesgroup> salesgroup;
    private Salesgroup salesGroupSelected;
    private String looked;
    private List<Integer> pageSize;
    private SalesGroupFilter filter = new SalesGroupFilter();

    @Init
    public void init() {
        setSalesgroup(new ListModelList<>(AppUtil.getWebService().getSalesgroups()));
        setPageSize(new ArrayList<>(Arrays.asList(sizeData)));
    }

    @Command
    public void listboxSelected(@BindingParam("window") Window window) {
        if (salesGroupSelected != null) {
            Map returnArgs = new HashMap();
            returnArgs.put("salesGroupSelected", salesGroupSelected);
            BindUtils.postGlobalCommand(null, null, "browseSelected", returnArgs);
            window.onClose();
        }
    }

    @Command
    @NotifyChange({"salesgroup"})
    public void changeList() {
        setSalesgroup(new ListModelList<>(getFilterSalesGroup(getLooked())));
    }
    
    @Command
    @NotifyChange({"salesgroup"})
    public void changeListSplit() {
        setSalesgroup(new ListModelList<>(getFilterSalesGroupSplit(getFilter())));
    }
    
    public static List<Salesgroup> getFilterSalesGroupSplit(SalesGroupFilter filter){
        List<Salesgroup> data = new ArrayList<>();
        List<Salesgroup> salesgroup = AppUtil.getWebService().getSalesgroups();
        String groupName = filter.getGroupName().toLowerCase();
        String groupCode = filter.getGroupCode().toLowerCase();

        for (Iterator<Salesgroup> i = salesgroup.iterator(); i.hasNext();) {
            Salesgroup tmp = i.next();
            if (tmp.getGroupCode().toLowerCase().contains(groupCode) && tmp.getGroupName().toLowerCase().contains(groupName)
                    ) {
                data.add(tmp);
            }

        }
        return data;
    }
    
    public static List<Salesgroup> getFilterSalesGroup(String salesGroupFilter) {
        List<Salesgroup> salesgrouplist = new ArrayList<>();
        salesGroupFilter = salesGroupFilter.toLowerCase();
        List<Salesgroup> salesgroup = AppUtil.getWebService().getSalesgroups();
        if (salesGroupFilter.isEmpty()) {
            return salesgroup;
        }
        
        for (Iterator<Salesgroup> i = salesgroup.iterator(); i.hasNext();) {
            Salesgroup tmp = i.next();
            if (tmp.getGroupCode().contains(salesGroupFilter)
                    || tmp.getGroupName().contains(salesGroupFilter)) {
                salesgrouplist.add(tmp);
            }
    
        }
        return salesgrouplist;
    }
    
    public ListModelList<Salesgroup> getSalesgroup() {
        return salesgroup;
    }

    public void setSalesgroup(ListModelList<Salesgroup> salesgroup) {
        this.salesgroup = salesgroup;
    }

    public Salesgroup getSalesGroupSelected() {
        return salesGroupSelected;
    }

    public void setSalesGroupSelected(Salesgroup salesGroupSelected) {
        this.salesGroupSelected = salesGroupSelected;
    }

    public String getLooked() {
        return looked;
    }

    public void setLooked(String looked) {
        this.looked = looked;
    }

    public List<Integer> getPageSize() {
        return pageSize;
    }

    public void setPageSize(List<Integer> pageSize) {
        this.pageSize = pageSize;
    }

    public SalesGroupFilter getFilter() {
        return filter;
    }

    public void setFilter(SalesGroupFilter filter) {
        this.filter = filter;
    }
    
    
}
