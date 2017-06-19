package com.lemonhexa.web.service;

import com.lemonhexa.web.entity.Companycategory;
import java.util.List;
import com.lemonhexa.web.entity.Geodata;
/**
 *
 * @author Ploychompoo
 */
public interface ServiceDao {
    
    public boolean save(Object o);
    
    public boolean delete(Object o);
    
    public boolean truncateDb();
    
    public  Geodata getGeodataById(Integer recordId);
    
    public List<Geodata> getGeodatas();
    
    public  Companycategory getCompanycategoryById(Integer recordId);
    
    public List<Companycategory> getCompanycategories();
}
