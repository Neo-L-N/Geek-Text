package com.bookstore.profilemanagement;

import java.util.List;

public interface UserRepository {
    void createUser(User user);
    User getUser(String username);
    void updateUser(String username, User updatedUser);
    void createCreditCard(String username, CreditCard creditCard);
}
