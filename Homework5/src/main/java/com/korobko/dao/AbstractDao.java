package com.korobko.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;

public abstract class AbstractDao<T> implements GenericDao<T> {

    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T create(T t) {

        return null;
    }

    @Override
    public T findById(Long id) {
        Class<T> t = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T object = null;
        try {
            object = t.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T delete(T t) {
        return null;
    }
}
