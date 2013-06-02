package com.ufasoli.tutorial.swagger.springmvc.core.dao;

import com.ufasoli.tutorial.swagger.springmvc.core.status.OperationResult;

import java.util.List;

/**
 * User: ufasoli
 * Date: 30/05/13
 * Time: 11:32
 * project : spring-mvc-swagger-tutorial
 */
public interface DAO<T, U> {

    public OperationResult create(T object);
    public OperationResult<T> update(U id, T object);
    public OperationResult delete(U id);
    public T findOne(U id);
    public List<T> findAll();

}
