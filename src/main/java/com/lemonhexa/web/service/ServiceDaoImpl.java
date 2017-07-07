package com.lemonhexa.web.service;

import com.lemonhexa.web.entity.Companycategory;
import com.lemonhexa.web.entity.Geodata;
import com.lemonhexa.web.entity.Salesgroup;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maikel
 */
@Service("serviceDao")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ServiceDaoImpl implements ServiceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = false)
    public boolean save(Object obj) {
        getCurrentSession().saveOrUpdate(obj);
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Object obj) {
        getCurrentSession().delete(obj);
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean truncateDb() {
        getCurrentSession().createSQLQuery("DELETE FROM lemonhexa.geodata;").executeUpdate();
        getCurrentSession().createSQLQuery("DELETE FROM lemonhexa.companycategory;").executeUpdate();
        return true;
    }
    
    @Override
    public Geodata getGeodataById(Integer recordId) {
        Geodata geodata = (Geodata) getCurrentSession().get(Geodata.class, recordId);
        return geodata;
    }

    @Override
    public List<Geodata> getGeodatas() {
        List<Geodata> listGeodata = getCurrentSession().createQuery("FROM Geodata a ORDER BY a.recordId ASC").list();
        return listGeodata;
    }

    @Override
    public Companycategory getCompanycategoryById(Integer recordId) {
        Companycategory companycategory = (Companycategory) getCurrentSession().get(Companycategory.class, recordId);
        return companycategory;
    }

    @Override
    public List<Companycategory> getCompanycategories() {
        List<Companycategory> listCompanycategory = getCurrentSession().createQuery("FROM Companycategory a ORDER BY a.recordId ASC").list();
        return listCompanycategory;
    }

    @Override
    public Salesgroup getSalesgroupById(Integer recordId) {
       Salesgroup salesgroup = (Salesgroup) getCurrentSession().get(Salesgroup.class, recordId);
        return salesgroup;
    }

    @Override
    public List<Salesgroup> getSalesgroups() {
        List<Salesgroup> listSalesgroup = getCurrentSession().createQuery("FROM Salesgroup a ORDER BY a.recordId ASC").list();
        return listSalesgroup;
    }
}
