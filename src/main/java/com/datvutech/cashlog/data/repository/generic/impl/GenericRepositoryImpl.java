package com.datvutech.cashlog.data.repository.generic.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.datvutech.cashlog.data.repository.generic.GenericRepository;

@Transactional
public class GenericRepositoryImpl<T> implements GenericRepository<T> {
    protected Class<T> typeClass;

    @Autowired
    protected SessionFactory sessionFactory;

    /* Begin: Constructors */
    protected GenericRepositoryImpl(Class<T> typeClass) {
        this.typeClass = typeClass;
    }

    /* End: Constructors */

    @Override
    public void insert(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    public void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public void delete(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "FROM " + typeClass.getSimpleName();
        List<T> resultList = session.createQuery(sql, typeClass)
                .getResultList();
        return resultList;
    }

    @Override
    public long countAll() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT count(*) FROM " + typeClass.getSimpleName();
        List<Long> count = session.createQuery(sql, Long.class)
                .getResultList();
        return count.get(0);
    }

}
