package com.bookstore.API;

import java.util.List;

import com.bookstore.API.BookSortingFeature.BookDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class JDBCRep implements UserDataRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BookDataModel> findGenre(String genre) {

        return jdbcTemplate.query("SELECT * from bookdata WHERE genre=?", BeanPropertyRowMapper.newInstance(BookDataModel.class), genre);
    }

    @Override
    public List<BookDataModel> sortRating(Integer rating) {

        return jdbcTemplate.query("SELECT * FROM bookstore.bookdata WHERE rating >=? ORDER BY rating ASC", BeanPropertyRowMapper.newInstance(BookDataModel.class), rating);

    }

    @Override
    public List<BookDataModel> bestSeller() {

        return jdbcTemplate.query("SELECT * from bookdata ORDER BY sold DESC", BeanPropertyRowMapper.newInstance(BookDataModel.class));
    }

    @Override
    public void updatePrice(String publisher, Integer discount) {

        jdbcTemplate.update("UPDATE bookstore.bookdata SET price = price - (price * (?/100)) WHERE publisher = ?", discount, publisher);

    }

    @Override
    public BookDataModel.UserDataModel findById(int userid) {
        BookDataModel.UserDataModel userDataModel = jdbcTemplate.queryForObject("SELECT * FROM userdata WHERE userID=?",
                BeanPropertyRowMapper.newInstance(BookDataModel.UserDataModel.class), userid);
        return userDataModel;

    }

    @Override
    public int save(BookDataModel.UserDataModel userDataModel) {
        return jdbcTemplate.update("INSERT INTO userdata (userName, userPassword, fullName, email, address, creditCard) VALUES(?,?,?,?,?,?)",
                new Object[] { userDataModel.getUserName(), userDataModel.getUserPassword(), userDataModel.getFullName(),
                        userDataModel.getEmail(), userDataModel.getAddress(), userDataModel.getCreditCard()});
    }

}
