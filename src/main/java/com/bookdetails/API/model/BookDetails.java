package com.bookdetails.API.model;

public class BookDetails {
    /* Book details: An administrator must be able to create a book with the book ISBN, book
    name, book description, price, author, genre, publisher , year published and
    copies sold.
    */



    private int isbn;
    private String title;
    private String description;
    private float price;
    private String author;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;

    public BookDetails(){

    }

    public BookDetails(int book_isbn, String book_name, String book_description, float price, String author, String genre, String publisher, int year_published,
                                                                                                                int copies_sold) {
        this.isbn = book_isbn;
        this.title = book_name;
        this.description = book_description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = year_published;
        this.copiesSold = copies_sold;

    }

    public BookDetails(String book_name, String description, int isbn){
        this.title = book_name;
        this.description = description;
        this.isbn = isbn;

    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int book_isbn) {
        this.isbn = book_isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String book_name) {
        this.title = book_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String book_description) {
        this.description = book_description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int YearPublished) {
        this.yearPublished = YearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copies_sold) {
        this.copiesSold = copies_sold;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "Book Isbn=" + isbn +
                ", Book Name='" + title + '\'' +
                ", Book Description='" + description + '\'' +
                ", Price=" + price +
                ", Author='" + author + '\'' +
                ", Genre='" + genre + '\'' +
                ", Publisher='" + publisher + '\'' +
                ", Year Published=" + yearPublished +
                ", Copies Sold=" + copiesSold +
                '}';
    }

}
