package com.geektext.api.model;

import com.fasterxml.jackson.annotation.JsonTypeId;

public class Book {

    private int isbn;
    private String title;
    private String description;
    private String authorFirst;
    private String authorLast;
    private String genre;
    private String publisher;
    private String biography;
    private int yearPublished;

    public Book() {

    }

    public Book(int book_isbn, String book_title, String book_description, String authorFirst, String authorLast) {
        this.isbn = book_isbn;
        this.title = book_title;
        this.description = book_description;
        this.authorFirst = authorFirst;
        this.authorLast = authorLast;
        this.genre = genre;
        this.publisher = publisher;
        this.biography = biography;
        this.yearPublished = year_published;
    }

    public Book(String book_title, String description, int isbn) {
        this.tile = book_title;
        this.description = description;
        this.isbn = isbn;
    }

    public int getIsbn() {
        g
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirst() {
        return authorFirst;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthorFirst(String authorFirst) {
        this.authorFirst = authorFirst;
    }

    public String getAuthorLast() {
        return authorLast;
    }

    public void setAuthorLast(String authorLast) {
        this.authorLast = authorLast;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Book Isbn=" + isbn + ", Book Title'" + title + '\'' + ", Book Description='" + description + '\'' +
                 ", Author='" + authorFirst + " " + authorLast + '\'' + ", Genre='" + genre + '\'' +
                ", Publisher='" + publisher + '\'' + ", Year Published=" + yearPublished + '}';
    }
}
