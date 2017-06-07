package com.lemonhexa.web.service;

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
    
    public  Geodata getGeodataById(Integer id);
    
    public List<Geodata> getGeodatas(); 
}
