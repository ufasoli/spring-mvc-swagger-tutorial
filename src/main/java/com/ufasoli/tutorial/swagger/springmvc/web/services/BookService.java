package com.ufasoli.tutorial.swagger.springmvc.web.services;


import com.ufasoli.tutorial.swagger.springmvc.core.dao.DAO;
import com.ufasoli.tutorial.swagger.springmvc.core.model.Book;
import com.ufasoli.tutorial.swagger.springmvc.core.status.OperationResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
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
     *
     * @param book The book object to store in the database
     */
    @ApiOperation(value = "Creates a Book")
    @RequestMapping(method = RequestMethod.POST)
    public  @ResponseBody void create(@ApiParam(required = true, name = "book", value = "The book object that needs to be created")@RequestBody Book book){

        bookDAO.create(book);


    }

    /**
     *
     * @param bookId the id of the book that should be updated
     * @param book the updated book object
     */
    @ApiOperation(value = "Method to update a book")
    @RequestMapping(method = RequestMethod.PUT, value = "/{bookId}")
    public  @ResponseBody OperationResult<Book> update(
            @ApiParam(required = true, value = "The id of the book that should be updated", name = "bookId")@PathVariable("bookId") String bookId,
                    @ApiParam(required = true, name = "book", value = "The book object that needs to be updated")@RequestBody Book book){

        return bookDAO.update(bookId, book);
    }

    /**
     *
     * @return all the Book objects in the database
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Lists all the books in the database")
    public  @ResponseBody List<Book> list(){
        return bookDAO.findAll();
    }

    /**
     *
     * @param bookId the id of the book that should be recovered
     * @return the book object corresponding to the bookId parameter of nunll if no book was found
     */
    @ApiOperation(value = "Retrieves a book based on their id")
    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public  @ResponseBody Book view(@ApiParam(name = "bookId" , required = true, value = "The id of the book that needs to be retrieved")@PathVariable("bookId") String bookId){
        return bookDAO.findOne(bookId);
    }

    /**
     *
     * @param bookId the id of the book to be deleted
     * @return an object indicating the outcome of the operation
     */
    @ApiOperation(value = "Deletes a book based on their id")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public  @ResponseBody OperationResult delete(@ApiParam(name = "bookId", value = "The id of the book to be deleted", required = true)@PathVariable("bookId") String bookId){
      return bookDAO.delete(bookId);


    }

}
