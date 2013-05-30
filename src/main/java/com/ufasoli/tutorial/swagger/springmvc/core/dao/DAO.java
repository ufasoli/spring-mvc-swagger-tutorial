package com.ufasoli.tutorial.swagger.springmvc.core.dao;

import java.util.List;

/**
 * User: ufasoli
 * Date: 30/05/13
 * Time: 11:32
 * project : spring-mvc-swagger-tutorial
 */
public interface DAO<T, U> {

    public T create(T object);
    public T update(U id, T object);
    public void delete(U id);
    public T findOne(U id);
    public List<T> findAll();

}
