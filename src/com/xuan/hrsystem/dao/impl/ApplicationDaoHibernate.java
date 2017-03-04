package com.xuan.hrsystem.dao.impl;

import com.xuan.hrsystem.dao.ApplicationDao;
import com.xuan.hrsystem.dao.base.MyHibernateDaoSupport;
import com.xuan.hrsystem.model.Application;
import com.xuan.hrsystem.model.Employee;

import java.util.List;

/**
 * Created by xuan on 2017/3/4 0004.
 */
@SuppressWarnings("JpaQlInspection")
public class ApplicationDaoHibernate extends MyHibernateDaoSupport implements ApplicationDao{
    @Override
    public Application get(Integer id) {
        return (Application)getHibernateTemplate()
                .get(Application.class, id);
    }

    @Override
    public Integer save(Application application) {
        return (Integer)getHibernateTemplate()
                .save(application);
    }

    @Override
    public void update(Application application) {
        getHibernateTemplate()
                .update(application);
    }

    @Override
    public void delete(Application application) {
        getHibernateTemplate()
                .delete(application);
    }

    @Override
    public void delete(Integer id) {
        getHibernateTemplate()
                .delete(get(id));
    }

    @Override
    public List<Application> findAll() {
        return (List<Application>)getHibernateTemplate()
                .find("from Application");
    }

    @Override
    public List<Application> findByEmp(Employee employee) {
        return (List<Application>)getHibernateTemplate()
                .find("from Application as a where " +
                "a.attend.employee=?", employee);
    }
}
