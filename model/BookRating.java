package com.geektext.api.model;

import java.util.Date;

public class BookRating {

    private int isbn;
    private String title;
    private String description;
    private int userID;
    double rating;
    double averageRating;
    private Date timestamp;

    public BookRating(int book_isbn, String book_title, String book_description, int userID, String book_comment,
                      date timestamp))
    {
        this.isbn = book_isbn;
        this.title = book_title;
        this.description = book_description;
        this.userID = userID;
        this.rating = book_rating;
        this.averageRating = average_rating;
        this.timestamp = timestamp;

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
        return "BookRating{" + "Book Isbn=" + isbn + ", Book Title'" + title + '\'' + ", Book Description='" + description + '\'' +
                    ", userID ='" + userID + '\'' + ", Book Rating='" + rating + '\'' +
                    ", Average Rating=" + averageRating + '\'' + ", Time Stamp=" + timestamp + '}';
    }

}
