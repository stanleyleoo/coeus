/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.component;

import com.lemonhexa.web.entity.Companycategory;
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
public class CompanyCategoryBrowseData {
    
    private final Integer[] sizeData = {5, 10, 20, 50, 100};
    private ListModelList<Companycategory> companycategory;
    private Companycategory companyCategorySelected;
    private String looked;
    private List<Integer> pageSize;
//    private GeodataFilter filter = new GeodataFilter();

    @Init
    public void init() {
        setCompanycategory(new ListModelList<>(AppUtil.getWebService().getCompanycategories()));
        setPageSize(new ArrayList<>(Arrays.asList(sizeData)));
    }

    @Command
    public void listboxSelected(@BindingParam("window") Window window) {
        if (companyCategorySelected != null) {
            Map returnArgs = new HashMap();
            returnArgs.put("companyCategorySelected", companyCategorySelected);
            BindUtils.postGlobalCommand(null, null, "browseSelected", returnArgs);
            window.onClose();
        }
    }

    @Command
    @NotifyChange({"companycategory"})
    public void changeList() {
        setCompanycategory(new ListModelList<>(getFilterCompanyCategory(getLooked())));
    }
    
//    @Command
//    @NotifyChange({"companycategory"})
//    public void changeListSplit() {
//        setGeodata(new ListModelList<>(getFilterGeodataSplit(getFilter())));
//    }
    
//    public static List<Geodata> getFilterGeodataSplit(GeodataFilter filter){
//        List<Geodata> data = new ArrayList<>();
//        List<Geodata> geodata = AppUtil.getWebService().getGeodatas();
//        String province = filter.getProvince().toLowerCase();
//        String country = filter.getCountry().toLowerCase();
//
//        for (Iterator<Geodata> i = geodata.iterator(); i.hasNext();) {
//            Geodata tmp = i.next();
//            if (tmp.getProvince().toLowerCase().contains(province) && tmp.getCountry().toLowerCase().contains(country)
//                    ) {
//                data.add(tmp);
//            }
//
//        }
//        return data;
//    }
    
    public static List<Companycategory> getFilterCompanyCategory(String companyCategoryFilter) {
        List<Companycategory> companycategorylist = new ArrayList<>();
        companyCategoryFilter = companyCategoryFilter.toLowerCase();
        List<Companycategory> companycategory = AppUtil.getWebService().getCompanycategories();
        if (companyCategoryFilter.isEmpty()) {
            return companycategory;
        }
        
        for (Iterator<Companycategory> i = companycategory.iterator(); i.hasNext();) {
            Companycategory tmp = i.next();
            if (tmp.getCategory().contains(companyCategoryFilter)
                    || tmp.getSub1().contains(companyCategoryFilter)) {
                companycategorylist.add(tmp);
            }

        }
        return companycategorylist;
    }
    
        
    //getter & setter

    public ListModelList<Companycategory> getCompanycategory() {
        return companycategory;
    }

    public void setCompanycategory(ListModelList<Companycategory> companycategory) {
        this.companycategory = companycategory;
    }

    public Companycategory getCompanyCategorySelected() {
        return companyCategorySelected;
    }

    public void setCompanyCategorySelected(Companycategory companyCategorySelected) {
        this.companyCategorySelected = companyCategorySelected;
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
