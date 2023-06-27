package com.bookdetails.API.repository;

import com.bookdetails.API.model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public class BooKDetails_JdbcRepositoryBookDetails implements BookDetails_MainRepository {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public int save(BookDetails BookDetails) {
            return jdbcTemplate.update("INSERT INTO bookdata (authorid, rating, genre, publisher, title, bookid, descript, ISBN, price, pubYear, sold) VALUES(?,?,?,?,?,?,?,?,?,?,?)",
                    new Object[] { BookDetails.getauthorid(), BookDetails.getRating(), BookDetails.getGenre(), BookDetails.getPublisher(), BookDetails.getTitle(),
                            BookDetails.getbookid(), BookDetails.getDescript(), BookDetails.getIsbn(), BookDetails.getPrice(), BookDetails.getPubYear(),
                                                                                        BookDetails.getSold(),});
        }

        @Override
        public int update(BookDetails BookDetails) {
            return jdbcTemplate.update("UPDATE bookdata SET title=?, descript=?, ISBN=? WHERE pubYear=?",
                    new Object[] { BookDetails.getTitle(), BookDetails.getDescript(), BookDetails.getIsbn(), BookDetails.getPubYear() });
        }

        @Override
        public BookDetails findByIsbn(String isbn) {
            try {
                BookDetails BookDetails = jdbcTemplate.queryForObject("SELECT * FROM bookdata WHERE ISBN=?",
                        BeanPropertyRowMapper.newInstance(BookDetails.class), isbn);

                return BookDetails;
            } catch (IncorrectResultSizeDataAccessException e) {
                return null;
            }
        }

        @Override
        public String deleteByIsbn(String isbn) {
            return String.valueOf(jdbcTemplate.update("DELETE FROM bookdata WHERE ISBN=?", isbn));
        }

        @Override
        public List<BookDetails> findAll() {
            return jdbcTemplate.query("SELECT * from bookdata", BeanPropertyRowMapper.newInstance(BookDetails.class));
        }
        @Override
        public List<BookDetails> findAllByID(int authorid) {
            return jdbcTemplate.query("SELECT * from bookdata WHERE authorid=?", BeanPropertyRowMapper.newInstance(BookDetails.class), authorid);
        }

        @Override
        public List<BookDetails> findByTitleContaining(String title) {
            String q = "SELECT * from bookdata WHERE title LIKE '%" + title + "%'";

            return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(BookDetails.class));
        }

        @Override
        public int deleteAll() {
            return jdbcTemplate.update("DELETE from bookdata");
        }
    }

