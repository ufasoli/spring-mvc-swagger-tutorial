package com.ufasoli.tutorial.swagger.springmvc.core.dao;

import com.ufasoli.tutorial.swagger.springmvc.core.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ufasoli
 * Date: 30/05/13
 * Time: 11:34
 * project : spring-mvc-swagger-tutorial
 */
@Service
public class BookDAO implements DAO<Book, String> {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Book create(Book object) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Book update(String id, Book object) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(String id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Book findOne(String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Book> findAll() {
       return template.query("SELECT * FROM BOOKS", new BeanPropertyRowMapper<Book>(Book.class));
    }
}
