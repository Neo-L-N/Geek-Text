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
            return jdbcTemplate.update("INSERT INTO Book Details (title, description, isbn) VALUES(?,?,?)",
                    new Object[] { BookDetails.getTitle(), BookDetails.getDescription(), BookDetails.getIsbn() });
        }

        @Override
        public int update(BookDetails BookDetails) {
            return jdbcTemplate.update("UPDATE tutorials SET title=?, description=?, isbn=? WHERE yearpublished=?",
                    new Object[] { BookDetails.getTitle(), BookDetails.getDescription(), BookDetails.getIsbn(), BookDetails.getYearPublished() });
        }

        @Override
        public BookDetails findByIsbn(int isbn) {
            try {
                BookDetails BookDetails = jdbcTemplate.queryForObject("SELECT * FROM tutorials WHERE isbn=?",
                        BeanPropertyRowMapper.newInstance(BookDetails.class), isbn);

                return BookDetails;
            } catch (IncorrectResultSizeDataAccessException e) {
                return null;
            }
        }

        @Override
        public int deleteByIsbn(int isbn) {
            return jdbcTemplate.update("DELETE FROM tutorials WHERE isbn=?", isbn);
        }

        @Override
        public List<BookDetails> findAll() {
            return jdbcTemplate.query("SELECT * from tutorials", BeanPropertyRowMapper.newInstance(BookDetails.class));
        }

        @Override
        public List<BookDetails> findByPublished(boolean published) {
            return jdbcTemplate.query("SELECT * from tutorials WHERE published=?",
                    BeanPropertyRowMapper.newInstance(BookDetails.class), published);
        }

        @Override
        public List<BookDetails> findByTitleContaining(String title) {
            String q = "SELECT * from tutorials WHERE title LIKE '%" + title + "%'";

            return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(BookDetails.class));
        }

        @Override
        public int deleteAll() {
            return jdbcTemplate.update("DELETE from tutorials");
        }
    }

