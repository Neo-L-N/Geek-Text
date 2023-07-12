package com.bookdetails.API.model;

public class AuthorData {

    private String firstname;
    private String lastname;
    private String publisher;
    private String biography;
    private int authorid;

    public AuthorData() {}
    
    public AuthorData(String firstname, String lastname, String publisher, String biography, int authorid){
        this.firstname = firstname;
        this.lastname = lastname;
        this.publisher = publisher;
        this.biography = biography;
        this.authorid = authorid;
    }
    public String getAuthorFullName() {
        return firstname + " " + lastname;
    }
    public String getfirstname() {return firstname;}
    public String getlastname() {return lastname;}
    public String getBiography() {return biography;}
    public void setBiography(String biography) {this.biography = biography;}
    public String getPublisher() {return publisher;}
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getauthorid() {return authorid;}
    public void setAuthorid(int authorid) {this.authorid = authorid;}
}
