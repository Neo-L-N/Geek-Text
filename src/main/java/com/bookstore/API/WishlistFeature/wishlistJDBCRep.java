package com.bookstore.API.WishlistFeature;

import java.util.List;

import com.bookstore.API.BookSortingFeature.BookDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * This is the restfull api repository that contains all the database queries.
 */
@Repository
public class wishlistJDBCRep implements UserDataRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * This method is used to retrieve information from the SQL database by genre.
     * @param genre This is the string that is passed to identify the genre
     * @return List of books by genre
     */
    @Override
    public List<BookDataModel> findGenre(String genre) {

        String mySqlQuery = "SELECT * from bookdata WHERE genre=?"; // holds the SQL query string
        return jdbcTemplate.query(mySqlQuery, BeanPropertyRowMapper.newInstance(BookDataModel.class), genre);
    }
    /**
     * This method is used to retrieve information from the SQL database by rating number.
     * @param rating This is the integer that is passed to identify the rating
     * @return List of books by rating
     */
    @Override
    public List<BookDataModel> sortRating(Integer rating) {

        return jdbcTemplate.query("SELECT * FROM bookstore.bookdata WHERE rating >=? ORDER BY rating ASC", BeanPropertyRowMapper.newInstance(BookDataModel.class), rating);

    }
    /**
     * This method is used to retrieve information from the SQL database by best seller
     * @return List of books by best seller
     */
    @Override
    public List<BookDataModel> bestSeller() {

        return jdbcTemplate.query("SELECT * from bookdata ORDER BY sold DESC", BeanPropertyRowMapper.newInstance(BookDataModel.class));
    }

    /**
     * This method is used to update book price information from the SQL database by a discount percentage by publisher.
     * @param publisher This is the string that is passed to identify the publisher
     * @param discount This is the float that is passed to identify the discount amount
     */
    @Override
    public void updatePrice(String publisher, Integer discount) {

        String mySqlQuery = "UPDATE bookstore.bookdata SET price = price - (price * (?/100)) WHERE publisher = ?";
        jdbcTemplate.update(mySqlQuery, discount, publisher);

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
