package com.geektext.api.model;

import java.util.Date;

public class BookCommenting{
    private long id;
    private int isbn;
    private String title;
    private String description;
    private int userID;
    private String comment;
    private Date timestamp;

    public BookCommenting(long id, int bookIsbn, String bookTitle, String bookDescription, int userID,
                              String bookComment, Date timestamp)
    {
        this.id = id;
        this.isbn = bookIsbn;
        this.title = bookTitle;
        this.description = bookDescription;
        this.userID = userID;
        this.comment = bookComment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString()
    {
        return "BookCommenting [id = " + id + ", Book Isbn=" + isbn + '\'' + ", Book Title'" + title + '\'' +
                ", Book Description='" + description + '\'' + ", userID ='" + userID + '\'' +
                ", Book Comment='" + comment + '\'' + ", Time Stamp=" + timestamp + "]";
    }
}

