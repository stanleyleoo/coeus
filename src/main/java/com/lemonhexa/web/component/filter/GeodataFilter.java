package com.lemonhexa.web.component.filter;

/**
 *
 * @author Ploychompoo
 */
public class GeodataFilter {
    private String country = "", province = "";

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country==null?"":country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province==null?"":province.trim();
    }

     
}
