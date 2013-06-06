package com.ufasoli.tutorial.swagger.springmvc.core.dao;

import com.google.common.base.Strings;
import com.ufasoli.tutorial.swagger.springmvc.core.model.Book;
import com.ufasoli.tutorial.swagger.springmvc.core.status.OperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public OperationResult create(Book book) {

        OperationResult result = new OperationResult(OperationResult.Status.UNKNOWN, "");
        String sql = "INSERT INTO BOOKS (id, title, author, publicationYear, comment) VALUES (?,?,?,?,?)";

        try {
            template.update(sql, new Object[]{book.getId(), book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getComment()});
            result.setStatus(OperationResult.Status.SUCCESS);
            result.setMessage(String.format("The book  [%s] was successfully created", book));
        } catch (Exception e) {
            result.setStatus(OperationResult.Status.ERROR);
            result.setMessage(String.format("An error occurred while processing the book [%s]. Error : [%s]", book, e.getMessage()));
        }

        return result;
    }

    @Override
    public OperationResult<Book> update(String id, Book book) {

        OperationResult<Book> result = new OperationResult<Book>(OperationResult.Status.UNKNOWN, "");
        if (Strings.isNullOrEmpty(id)) {
            throw new IllegalArgumentException(String.format("The parameter [id] cannot be null. recieved [%s]", id));
        }

        if (book == null) {
            throw new IllegalArgumentException(String.format("The parameter [book] cannot be null. recieved [%s]", book));
        }

        String sqlUpdate = "UPDATE BOOKS set title =?, author=?, publicationYear=?, comment=? WHERE id=?";

        try {
            int nbRows = template.update(sqlUpdate, new Object[]{book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getComment(), id});
            result.setStatus(OperationResult.Status.SUCCESS);
            result.setMessage(String.format("The request was successfully processed [%s] records updated", nbRows));
            result.setData(book);

        } catch (Exception e) {
            result.setStatus(OperationResult.Status.ERROR);
            result.setMessage(String.format("An error occurred while attempting to delete the book [%s]. Error : [%s]", id, e.getMessage()));
        }

        return result;
    }

    @Override
    public OperationResult delete(String id) {
        OperationResult result = new OperationResult(OperationResult.Status.UNKNOWN, "");
        if (Strings.isNullOrEmpty(id)) {
            throw new IllegalArgumentException(String.format("The parameter [id] cannot be null. recieved [%s]", id));
        }

        String sqlDelete = "DELETE FROM BOOKS WHERE id = ?";

        try {
            int nbRows = template.update(sqlDelete, new Object[]{id});
            result.setStatus(OperationResult.Status.SUCCESS);
            result.setMessage(String.format("The request was successfully processed [%s] records deletes", nbRows));

        } catch (Exception e) {
            result.setStatus(OperationResult.Status.ERROR);
            result.setMessage(String.format("An error occurred while attempting to delete the book [%s]. Error : [%s]", id, e.getMessage()));
        }

        return result;
    }

    @Override
    public Book findOne(String id) {
        try{
            return template.queryForObject("SELECT * FROM BOOKS WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Book>(Book.class));
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Book> findAll() {
        return template.query("SELECT * FROM BOOKS",new BeanPropertyRowMapper<Book>(Book.class));
    }
}
