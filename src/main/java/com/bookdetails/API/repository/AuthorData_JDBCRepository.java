package com.bookdetails.API.repository;


import com.bookdetails.API.model.AuthorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorData_JDBCRepository implements AuthorData_Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(AuthorData author) {
        return jdbcTemplate.update("INSERT INTO authordata (firstname, lastname, biography, publisher, authorid) VALUES(?,?,?,?,?)",
                new Object[] { author.getfirstname(), author.getlastname(), author.getBiography(), author.getPublisher(), author.getauthorid()});
    }

  /*  @Override
    public int update(authorData author) {
        return jdbcTemplate.update("UPDATE authordata SET title=?, descript=?, ISBN=? WHERE pubYear=?",
                new Object[] { authorData.getTitle(), authorData.getDescription(), authorData.getIsbn(), authorData.getYearPublished() });
    }

   */
    @Override
    public AuthorData findByID(int authorID) {
       try{
           AuthorData authorData = jdbcTemplate.queryForObject("SELECT * FROM authordata WHERE authorid=?",
                   BeanPropertyRowMapper.newInstance(AuthorData.class), authorID);
            return authorData;
       } catch(IncorrectResultSizeDataAccessException e) {
           return null;
       }


    }
}