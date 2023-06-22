package com.bookdetails.API.repository;

import com.bookdetails.API.model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public class JdbcRepository implements MainRepository {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public int save(BookDetails BookDetails) {
            return jdbcTemplate.update("INSERT INTO bookdetails (title, description, isbn, price, yearPublished, copiesSold) VALUES(?,?,?,?,?,?)",
                    new Object[] { BookDetails.getTitle(), BookDetails.getDescription(), BookDetails.getIsbn(), BookDetails.getPrice(), BookDetails.getYearPublished(),
                                                                                        BookDetails.getCopiesSold(),});
        }

        @Override
        public int update(BookDetails BookDetails) {
            return jdbcTemplate.update("UPDATE bookdetails SET title=?, description=?, isbn=? WHERE yearPublished=?",
                    new Object[] { BookDetails.getTitle(), BookDetails.getDescription(), BookDetails.getIsbn(), BookDetails.getYearPublished() });
        }

        @Override
        public BookDetails findByIsbn(int isbn) {
            try {
                BookDetails BookDetails = jdbcTemplate.queryForObject("SELECT * FROM bookdetails WHERE isbn=?",
                        BeanPropertyRowMapper.newInstance(BookDetails.class), isbn);

                return BookDetails;
            } catch (IncorrectResultSizeDataAccessException e) {
                return null;
            }
        }

        @Override
        public int deleteByIsbn(int isbn) {
            return jdbcTemplate.update("DELETE FROM bookdetails WHERE isbn=?", isbn);
        }

        @Override
        public List<BookDetails> findAll() {
            return jdbcTemplate.query("SELECT * from bookdetails", BeanPropertyRowMapper.newInstance(BookDetails.class));
        }

        @Override
        public List<BookDetails> findByPublished(boolean published) {
            return jdbcTemplate.query("SELECT * from bookdetails WHERE published=?",
                    BeanPropertyRowMapper.newInstance(BookDetails.class), published);
        }

        @Override
        public List<BookDetails> findByTitleContaining(String title) {
            String q = "SELECT * from bookdetails WHERE title LIKE '%" + title + "%'";

            return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(BookDetails.class));
        }

        @Override
        public int deleteAll() {
            return jdbcTemplate.update("DELETE from bookdetails");
        }
    }

