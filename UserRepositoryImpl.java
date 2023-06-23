package com.bookstore.profilemanagement;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO users (username, password, name, email, address) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getName(),
                user.getEmail(), user.getAddress());
    }

    @Override
    public User getUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
    }

    @Override
    public void updateUser(String username, User updatedUser) {
        String sql = "UPDATE users SET name = ?, email = ?, address = ? WHERE username = ?";
        jdbcTemplate.update(sql, updatedUser.getName(), updatedUser.getEmail(),
                updatedUser.getAddress(), username);
    }

    @Override // Implement credit card creation logic
    public void createCreditCard(String username, CreditCard creditCard) {
    }
}
