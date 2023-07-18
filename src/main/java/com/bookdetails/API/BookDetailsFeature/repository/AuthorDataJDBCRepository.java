package com.bookdetails.API.BookDetailsFeature.repository;


import com.bookdetails.API.BookDetailsFeature.model.AuthorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDataJDBCRepository implements AuthorDataRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(AuthorData author) {
        return jdbcTemplate.update("INSERT INTO authordata (firstname, lastname, biography, publisher, authorid) VALUES(?,?,?,?,?)",
                new Object[] { author.getfirstname(), author.getlastname(), author.getBiography(), author.getPublisher(), author.getauthorid()});
    }

}
