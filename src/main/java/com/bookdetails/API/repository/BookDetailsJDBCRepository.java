package com.bookdetails.API.repository;

import com.bookdetails.API.model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public class BookDetailsJDBCRepository implements BookDetailsRepository {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public int save(BookDetails BookDetails) {
            return jdbcTemplate.update("INSERT INTO bookdata (authorid, rating, genre, publisher, title, descript, ISBN, price, pubYear, sold, bookid) VALUES(?,?,?,?,?,?,?,?,?,?,?)",
                    new Object[] { BookDetails.getAuthorid(), BookDetails.getRating(), BookDetails.getGenre(), BookDetails.getPublisher(), BookDetails.getTitle(),
                             BookDetails.getDescript(), BookDetails.getIsbn(), BookDetails.getPrice(), BookDetails.getPubYear(),
                                                                                        BookDetails.getSold(),BookDetails.getBookid()});
        }

        @Override
        public int update(BookDetails BookDetails) {
            return jdbcTemplate.update("UPDATE bookdata SET title=?, descript=?, ISBN=? WHERE pubYear=?",
                    new Object[] { BookDetails.getTitle(), BookDetails.getDescript(), BookDetails.getIsbn(), BookDetails.getPubYear() });
        }

        @Override
        public BookDetails findByIsbn(String isbn) {
            try {
                BookDetails book = jdbcTemplate.queryForObject("SELECT * FROM bookdata WHERE ISBN=?",
                        BeanPropertyRowMapper.newInstance(BookDetails.class), isbn);

                return book;
            } catch (IncorrectResultSizeDataAccessException e) {
                return null;
            }
        }

        @Override
        public String deleteByIsbn(String isbn) {
            return String.valueOf(jdbcTemplate.update("DELETE FROM bookdata WHERE ISBN=?", isbn));
        }
        @Override
        public List<BookDetails> findAll(){
            return jdbcTemplate.query("SELECT * FROM bookdata", (rs, rowNum) ->
                    new BookDetails(rs.getInt("authorid"),
                                    rs.getInt("rating"),
                                    rs.getString("genre"),
                                    rs.getString("publisher"),
                                    rs.getString("title"),
                                    rs.getString("descript"),
                                    rs.getString("isbn"),
                                    rs.getInt("price"),
                                    rs.getInt("pubYear"),
                                    rs.getInt("sold"),
                                    rs.getInt("bookid"))
            );
        }

        @Override
        public List<BookDetails> findByTitleContaining(String title) {
            String q = "SELECT * from bookdata WHERE title LIKE '%" + title + "%'";

            return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(BookDetails.class));
        }
        @Override
        public List<BookDetails> findAllByAuthorID(int authorid) {
            String s = "SELECT * FROM bookdata WHERE authorid like ?";
            return jdbcTemplate.query(s, new Object[]{"%" + authorid + "%"}, (rs, rowNum) ->

                    new BookDetails(rs.getInt("authorid"),
                            rs.getInt("rating"),
                            rs.getString("genre"),
                            rs.getString("publisher"),
                            rs.getString("title"),
                            rs.getString("descript"),
                            rs.getString("isbn"),
                            rs.getInt("price"),
                            rs.getInt("pubYear"),
                            rs.getInt("sold"),
                            rs.getInt("bookid")));

        }

        @Override
        public int deleteAll() {
            return jdbcTemplate.update("DELETE from bookdata");
        }
    }

