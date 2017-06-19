/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.component;

import com.lemonhexa.web.entity.Geodata;
import com.lemonhexa.web.component.filter.GeodataFilter;
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
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

/**
 *
 * @author Ploychompoo
 */
public class GeodataBrowseData {
    
    private final Integer[] sizeData = {5, 10, 20, 50, 100};
    private ListModelList<Geodata> geodata;
    private Geodata geodataSelected;
    private String looked;
    private List<Integer> pageSize;
    private GeodataFilter filter = new GeodataFilter();

    @Init
    public void init() {
        getFilter();
        setGeodata(new ListModelList<>(AppUtil.getWebService().getGeodatas()));
        setPageSize(new ArrayList<>(Arrays.asList(sizeData)));
    }

    @Command
    public void listboxSelected(@BindingParam("window") Window window) {
        if (geodataSelected != null) {
            Map returnArgs = new HashMap();
            returnArgs.put("geodataSelected", geodataSelected);
            BindUtils.postGlobalCommand(null, null, "browseSelected", returnArgs);
            window.onClose();
        }
    }

    @Command
    @NotifyChange({"geodata"})
    public void changeList() {
        setGeodata(new ListModelList<>(getFilterGeodata(getLooked())));
    }
    
    @Command
    @NotifyChange({"geodata"})
    public void changeListSplit() {
        setGeodata(new ListModelList<>(getFilterGeodataSplit(getFilter())));
    }
    
    public static List<Geodata> getFilterGeodataSplit(GeodataFilter filter){
        List<Geodata> data = new ArrayList<>();
        List<Geodata> geodata = AppUtil.getWebService().getGeodatas();
        String province = filter.getProvince().toLowerCase();
        String country = filter.getCountry().toLowerCase();

        for (Iterator<Geodata> i = geodata.iterator(); i.hasNext();) {
            Geodata tmp = i.next();
            if (tmp.getProvince().toLowerCase().contains(province) && tmp.getCountry().toLowerCase().contains(country)
                    ) {
                data.add(tmp);
            }

        }
        return data;
    }
    
    public static List<Geodata> getFilterGeodata(String geodataFilter) {
        List<Geodata> geodatalist = new ArrayList<>();
        geodataFilter = geodataFilter.toLowerCase();
        List<Geodata> geodata = AppUtil.getWebService().getGeodatas();
        if (geodataFilter.isEmpty()) {
            return geodata;
        }
        
        for (Iterator<Geodata> i = geodata.iterator(); i.hasNext();) {
            Geodata tmp = i.next();
            if (tmp.getCountry().contains(geodataFilter)
                    || tmp.getProvince().contains(geodataFilter)) {
                geodatalist.add(tmp);
            }

        }
        return geodatalist;
    }
    
    
    public GeodataFilter getFilter() {
        return filter;
    }
    
    //getter & setter
    
    public ListModelList<Geodata> getGeodata() {
        return geodata;
    }

    public void setGeodata(ListModelList<Geodata> geodata) {
        this.geodata = geodata;
    }

    public Geodata getGeodataSelected() {
        return geodataSelected;
    }

    public void setGeodataSelected(Geodata geodataSelected) {
        this.geodataSelected = geodataSelected;
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
    
    
}
