package com.bookstore.API.bookBrowsingSortingFeature.repository;

import java.util.List;

import com.bookstore.API.bookBrowsingSortingFeature.model.BookDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class BrowsingSortingJDBCRep implements BrowsingSortingService {

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


    public static interface BrowsingSortingService {

        List<BookDataModel> findGenre(String genre);

        List<BookDataModel> sortRating(Integer rating);

        List<BookDataModel> bestSeller();

        void updatePrice(String publisher, Integer discount);


    }
}
