package com.ufasoli.tutorial.swagger.springmvc.web.services;


import com.ufasoli.tutorial.swagger.springmvc.core.dao.DAO;
import com.ufasoli.tutorial.swagger.springmvc.core.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * User: ufasoli
 * Date: 30/05/13
 * Time: 11:11
 * project : spring-mvc-swagger-tutorial
 */
@Controller
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookService {

    @Autowired
    private DAO<Book, String> bookDAO;

    /**
     * Creates a book object
     * Returns HTTP status Code 201 if book was successfully created
     *
     * @param book The book object to store in the database
     */
    @RequestMapping(method = RequestMethod.POST)
    public  @ResponseBody void create(@RequestBody Book book){

        bookDAO.create(book);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{bookId}")
    public  @ResponseBody void update(@PathVariable("bookId") String bookId, @RequestBody Book book){

    }

    @RequestMapping(method = RequestMethod.GET)
    public  @ResponseBody List<Book> list(){
        return bookDAO.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public  @ResponseBody Book view(@PathVariable("bookId") String bookId){
        return bookDAO.findOne(bookId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public  @ResponseBody void delete(@PathVariable("bookId") String bookId){

    }
}
