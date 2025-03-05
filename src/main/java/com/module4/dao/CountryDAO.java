package com.module4.dao;

import com.module4.domain.Country;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CountryDAO {
    private final SessionFactory sessionFactory;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAll() {

        String s = "select c from Country c join fetch c.languages";

        Query<Country> query = sessionFactory.getCurrentSession().createQuery(s, Country.class);
        return query.list();
    }
}