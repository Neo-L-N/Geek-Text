package com.bookstore.API.bookBrowsingSortingFeature.controller;

import com.bookstore.API.bookBrowsingSortingFeature.model.BookDataModel;
import com.bookstore.API.bookBrowsingSortingFeature.repository.BrowsingSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This is the restfull api controller that contains all the mapping endpoints
 * for the requests.
 */
@RestController
public class BrowsingSortingController {

    @Autowired // injects the JDBC
    BrowsingSortingService interfaceChoice;

    @GetMapping("/gen/{genre}") // genre variable
    // This gets a list of books by the user specified genre
    public ResponseEntity<List<BookDataModel>> findBookGenre(@PathVariable("genre") String genre) {

        List<BookDataModel> bookDataModels = interfaceChoice.findGenre(genre);

        if (bookDataModels != null) {
            return new ResponseEntity<>(bookDataModels, HttpStatus.OK);
        } // end if
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } // end else

    } // end @getMapping

    @GetMapping("/rating/{rating}")
    // This gets a list of books by the user specified rating
    public List<BookDataModel> sortRating(@PathVariable("rating") Integer rating) {

        List<BookDataModel> bookDataModels = interfaceChoice.sortRating(rating);

        return bookDataModels; // returns the list of books
    }

    @GetMapping("/sold")
    // This returns a list of books sorted by the best sold books
    public List<BookDataModel> bestSeller() {

        List<BookDataModel> bookDataModels = interfaceChoice.bestSeller();

        return bookDataModels; // returns the list of books
    }

    @PutMapping("/discount/{publisher}/{discount}")
    // This updates the book prices by a user specified discount percentage on the books by a user specified publisher
    public void updatePrice(@PathVariable("publisher") String publisher, @PathVariable("discount") Integer discount) {

        interfaceChoice.updatePrice(publisher, discount); // passes the publisher and discount variables to the Repository

    }

}
