package com.bookstore.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class JDBCRep implements UserDataRepository {  // changed from implements to extends

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDataModel findById(int userID) {
        UserDataModel userDataModel = jdbcTemplate.queryForObject("SELECT * FROM userdata WHERE userID=?",
                   BeanPropertyRowMapper.newInstance(UserDataModel.class), userID);
        return userDataModel;

    }

    @Override
    public int save(UserDataModel userDataModel) {
        return jdbcTemplate.update("INSERT INTO userdata (userName, userPassword, fullName, email, address, creditCard) VALUES(?,?,?,?,?,?)",
                new Object[] { userDataModel.getUserName(), userDataModel.getUserPassword(), userDataModel.getFullName(),
                        userDataModel.getEmail(), userDataModel.getAddress(), userDataModel.getCreditCard()});
    }

    ////////// book data

    @Override
    public List<BookDataModel> findGenre(String genre) {

        return jdbcTemplate.query("SELECT * from bookdata WHERE genre=?", BeanPropertyRowMapper.newInstance(BookDataModel.class), genre);
    }

    @Override
    public List<BookDataModel> sortRating() {

        return jdbcTemplate.query("SELECT * from bookdata ORDER BY rating", BeanPropertyRowMapper.newInstance(BookDataModel.class));
    }

    @Override
    public List<BookDataModel> bestSeller() {

        return jdbcTemplate.query("SELECT * from bookdata ORDER BY sold DESC", BeanPropertyRowMapper.newInstance(BookDataModel.class));
    }


}
