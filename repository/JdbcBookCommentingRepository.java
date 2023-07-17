package com.geektext.api.repository;

import com.geektext.api.model.BookCommenting;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.Jdbctemplate;
import org.springframework.stereotype.Repository;

/* JdbcBookCommentingRepository implements BookCommentingRepository by using JdbcTemplate object to execute
SQL queries or updates to interact with MySQL Database.
 */

@BookCommentingRepository
public class JdbcBookCommentingRepository implements BookCommentingRepository {
@Autowired
private JdbcTemplate jdbcTemplate;

public JdbcBookCommentingRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
}
@Override
public int save(BookCommenting bookCommenting)
    {
    return jdbcTemplate.update("INSERT INTO BookCommenting (title, comment, timestamp) VALUES(?, ?, ?)",
            new Object[]{BookCommenting.getTitle(), BookCommenting.getComment(), BookCommenting.getTimestamp()} );
    }

    @Override
    public BookCommenting findById(Long id)
    {
        try
        {
            BookCommenting bookCommenting = jdbcTemplate.queryForObject("SELECT *FROM bookCommenting WHERE id =?",
                    BeanPropertyRowMapper.newInstance(BookCommenting.class), id);
            return BookCommenting;
        }
        catch (IncorrectResultSizeDataAccessException e)
        {
            return null;
        }
    }
    @Override
    public int deleteById(Long id)
    {
        return jdbcTemplate.update("DELETE * from bookCommenting WHERE id = ?", id);
    }
    @Override
    public List<BookCommenting> findAll()
    {
        return jdbcTemplate.query("SELECT * from bookCommenting",
                BeanPropertyRowMapper.newInstance(BookCommenting.class));
    }
    @Override
    public List<BookCommenting> findByTitleContaining(String title)
    {
        String q = "SELECT * from bookCommenting WHERE title LIKE '%" + title + "%'";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(BookCommenting.class));
    }
    @Override
    public int deleteAll()
    {
        return jdbcTemplate.update("DELETE from bookCommenting");
    }
}
