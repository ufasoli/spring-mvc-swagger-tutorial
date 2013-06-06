package com.ufasoli.tutorial.swagger.springmvc.core.dao;

import com.ufasoli.tutorial.swagger.springmvc.core.status.OperationResult;
import java.util.List;

/**
 * Simple DAO CRUD interface
 * User: ufasoli
 * Date: 30/05/13
 * Time: 11:32
 * project : spring-mvc-swagger-tutorial
 */
public interface DAO<T, U> {

    /**
     * Creates a given object in the database
     *
     * @param object the object to store in the database
     * @return an object indicating whether the operation was successfully conducted
     */
    public OperationResult create(T object);

    /**
     * Updates a given object in the database
     * @param id the id of the object to update
     * @param object the object to be updated with the new values
     * @return an object indicating whether the operation was successfully conducted
     */
    public OperationResult<T> update(U id, T object);

    /**
     * Deletes an object in the database based on the id
     * @param id the id of the object to be deleted
     * @return an object indicating whether the operation was successfully conducted
     */
    public OperationResult delete(U id);

    /**
     * Finds an object based on their id
     * @param id the id of the object to be retrieved
     * @return the object corresponding to the id parameter or null if none is found
     */
    public T findOne(U id);

    /**
     * Returns all of the objects in the database for a given table
     * @return a list of all the objects in the database for a given table
     */
    public List<T> findAll();

}
