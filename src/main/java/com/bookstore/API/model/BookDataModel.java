package com.bookstore.API.model;

public class BookDataModel {

    private Integer authorid;
    private String sold;
    private String descript;
    private String genre;
    private String isbn;
    private Float price;
    private String publisher;
    private Integer rating;
    private String title;
    private Integer pubYear;
    private Integer bookid;


    public BookDataModel(Integer authorid, String sold, String descript, String genre, String isbn, Float price, String publisher, Integer rating, String title, Integer pubYear, Integer bookID) {
        this.authorid = authorid;
        this.sold = sold;
        this.descript = descript;
        this.genre = genre;
        this.isbn = isbn;
        this.price = price;
        this.publisher = publisher;
        this.rating = rating;
        this.title = title;
        this.pubYear = pubYear;
        this.bookid = bookid;
    }



    public BookDataModel() {

    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    @Override
    public String toString() {
        return "BookDataModel{" +
                "authorID=" + authorid +
                ", sold='" + sold + '\'' +
                ", descript='" + descript + '\'' +
                ", genre='" + genre + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", pubYear=" + pubYear +
                ", bookID=" + bookid +
                '}';
    }

}