package com.geektext.api.model;

import java.util.Date;

public class BookRating {

    private long id;
    private int isbn;
    private String title;
    private String description;
    private int userID;
    double rating;
    double averageRating;
    private Date timestamp;

    public BookRating(long id, int bookIsbn, String bookTitle, String bookDescription, int userID, double bookRating,
                      double averageRating, Date timestamp)
    {
        this.id = id;
        this.isbn = bookIsbn;
        this.title = bookTitle;
        this.description = bookDescription;
        this.userID = userID;
        this.rating = bookRating;
        this.averageRating = averageRating;
        this.timestamp = timestamp;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIsbn() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "BookRating [id = " + id + ", Book Isbn=" + isbn + ", Book Title'" + title + '\'' +
                ", Book Description='" + description + '\'' + ", userID ='" + userID + '\'' +
                ", Book Rating='" + rating + '\'' + ", Average Rating=" + averageRating + '\''
                + ", Time Stamp=" + timestamp + "]";
    }
}

