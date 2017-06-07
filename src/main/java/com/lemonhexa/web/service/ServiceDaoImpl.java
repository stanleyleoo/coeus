package com.lemonhexa.web.service;

import com.lemonhexa.web.entity.Geodata;
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
        return true;
    }
    
    @Override
    public Geodata getGeodataById(Integer id) {
        Geodata geodata = (Geodata) getCurrentSession().get(Geodata.class, id);
        return geodata;
    }

    @Override
    public List<Geodata> getGeodatas() {
        List<Geodata> listGeodata = getCurrentSession().createQuery("FROM Geodata a ORDER BY a.id ASC").list();
        return listGeodata;
    }
}
