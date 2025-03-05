package com.module4.dao;

import com.module4.domain.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CityDAO {
    private final SessionFactory sessionFactory;

    public CityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<City> getItems(int offset, int limit) {

        String s = "select c from City c";

        Query<City> query = sessionFactory.getCurrentSession().createQuery(s, City.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public int getTotalCount() {

        String s = "select count(c) from City c";

        Query<Long> query = sessionFactory.getCurrentSession().createQuery(s, Long.class);
        return Math.toIntExact(query.uniqueResult());
    }

    public City getById(Integer id) {

        String s = "select c from City c join fetch c.country where c.id = :ID";

        Query<City> query = sessionFactory.getCurrentSession().createQuery(s, City.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }

}