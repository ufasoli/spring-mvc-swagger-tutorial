package com.ufasoli.tutorial.swagger.springmvc.core.model;

import java.io.Serializable;

/**
 * User: ufasoli
 * Date: 30/05/13
 * Time: 11:12
 * project : spring-mvc-swagger-tutorial
 */
public class Book implements Serializable {

    private String id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String comment;

    public Book(){

    }
    public Book(String id, String title, String author, Integer publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
