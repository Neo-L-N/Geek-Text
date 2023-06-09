package com.bookstore.API;

public class UserDataModel {

    private String userName;
    private String userPassword;
    private String fullName;
    private String email;
    private String address;
    private String creditCard;
    private int userID;

    public UserDataModel(String userName, String userPassword, String fullName, String email, String address, String creditCard, int userID) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.creditCard = creditCard;
        this.userID = userID;
    }

    public UserDataModel(String userName, String userPassword, String fullName, String email, String address, String creditCard) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.creditCard = creditCard;
    }
    public UserDataModel() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "UserDataModel{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", userID=" + userID +
                '}';
    }
}
