package com.xuan.hrsystem.dao.base;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xuan on 2017/3/4 0004.
 */
public class MyHibernateDaoSupport extends HibernateDaoSupport {
    public List findByPage(final String hql,
                           final int offset, final int pageSize) {
        List list = getHibernateTemplate()
                .executeFind(new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session) throws HibernateException, SQLException {
                        List result = session.createQuery(hql)
                                .setFirstResult(offset)
                                .setMaxResults(pageSize)
                                .list();
                        return result;
                    }
                });
        return list;
    }

    public List findByPage(final String hql, final Object value,
                           final int offset, final int pageSize) {
        List list = getHibernateTemplate()
                .executeFind(new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session) throws HibernateException, SQLException {
                        List result = session.createQuery(hql)
                                .setParameter(0, value)
                                .setFirstResult(offset)
                                .setMaxResults(pageSize)
                                .list();
                        return result;
                    }
                });
        return list;
    }

    public List findByPage(final String hql, final Object[] values,
                           final int offset, final int pageSize) {
        List list = getHibernateTemplate()
                .executeFind(new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session) throws HibernateException, SQLException {
                        List result;
                        Query query = session.createQuery(hql);
                        for (int i = 0; i < values.length; i++) {
                            query.setParameter(i, values[i]);
                        }
                        result = query.setFirstResult(offset)
                                .setMaxResults(pageSize)
                                .list();
                        return result;
                    }
                });
        return list;
    }
}
