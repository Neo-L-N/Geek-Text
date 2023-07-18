package com.bookstore.API.BookDetailsFeature.model;

public class BookDetails {
    /* Book details: An administrator must be able to create a book with the book ISBN, book
    name, book description, price, author, genre, publisher , year published and
    copies sold.
    */
    private String isbn;
    private String title;
    private String descript;
    private int price;
    private String genre;
    private String publisher;
    private int rating;
    private int pubYear;
    private int sold;
    private int authorid;
    private int bookid;

    public BookDetails(){}

    public BookDetails(int authorid, int rating, String genre, String publisher, String book_name, String descript, String isbn, int price, int year_Published, int copies_Sold, int bookid){
        this.title = book_name;
        this.descript = descript;
        this.isbn = isbn;
        this.price = price;
        this.pubYear = year_Published;
        this.sold = copies_Sold;
        this.authorid = authorid;
        this.bookid = bookid;
        this.rating = rating;
        this.genre = genre;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String book_isbn) {
        this.isbn = book_isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String book_name) {
        this.title = book_name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String book_description) {
        this.descript = book_description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    //public void setAuthor(String author) {
     //   this.author = author;
  // }
    public int getAuthorid() {return bookid;}
    public int getBookid() {
        return authorid;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int YearPublished) {
        this.pubYear = YearPublished;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int copies_sold) {
        this.sold = copies_sold;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "Book Isbn=" + isbn +
                ", Book Name='" + title + '\'' +
                ", Book Description='" + descript + '\'' +
                ", Price=" + price + '\'' +
                ", Genre='" + genre + '\'' +
                ", Year Published=" + pubYear +
                ", Copies Sold=" + sold +
                '}';
    }


}
