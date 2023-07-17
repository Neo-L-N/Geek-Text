package com.geektext.api.repository;

import com.geektext.api.model.BookRating;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.Jdbctemplate;
import org.springframework.stereotype.Repository;

/* JdbcBookRatingRepository implements BookRatingRepository by using JdbcTemplate object to execute
SQL queries or updates to interact with MySQL Database.
 */

@BookRatingRepository
public class JdbcBookRatingRepository implements BookRatingRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcBookRatingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int save(BookRating bookRating)
    {
        return jdbcTemplate.update("INSERT INTO BookRating(title, rating, averageRating, timestamp) VALUES(?, ?, ?, ?)",
                new Object[]{BookRating.getTitle(), BookRating.getRating(), BookRating.getAverageRating(),BookRating.getTimestamp()} );
    }

    @Override
    public BookRatingfindById(Long id)
    {
        try
        {
            BookRating bookRating = jdbcTemplate.queryForObject("SELECT *FROM bookRating WHERE id =?",
                    BeanPropertyRowMapper.newInstance(BookRating.class), id);
            return BookRating;
        }
        catch (IncorrectResultSizeDataAccessException e)
        {
            return null;
        }
    }
    @Override
    public int deleteById(Long id)
    {
        return jdbcTemplate.update("DELETE * from bookRating WHERE id = ?", id);
    }
    @Override
    public List<BookRating> findAll()
    {
        return jdbcTemplate.query("SELECT * from bookRating",
                BeanPropertyRowMapper.newInstance(BookRating.class));
    }
    @Override
    public List<BookRating> findByTitleContaining(String title)
    {
        String q = "SELECT * from bookRating WHERE title LIKE '%" + title + "%'";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(BookRating.class));
    }
    @Override
    public int deleteAll()
    {
        return jdbcTemplate.update("DELETE from bookRating");
    }

}

