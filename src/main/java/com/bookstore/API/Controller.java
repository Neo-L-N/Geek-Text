package com.bookstore.API;

import com.bookstore.API.BookSortingFeature.BookDataModel;
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
public class Controller {

    @Autowired // injects the JDBC
    UserDataRepository interfaceChoice;

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
    public ResponseEntity<List<BookDataModel>> bestSeller() {

        List<BookDataModel> bookDataModels = interfaceChoice.bestSeller();

        if (bookDataModels != null) {
            return new ResponseEntity<>(bookDataModels, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //return bookDataModels; // returns the list of books
    }

    @PutMapping("/discount/{publisher}/{discount}")
    // This updates the book prices by a user specified discount percentage on the books by a user specified publisher
    public void updatePrice(@PathVariable("publisher") String publisher, @PathVariable("discount") Integer discount) {

        interfaceChoice.updatePrice(publisher, discount); // passes the publisher and discount variables to the Repository

    }

    @RequestMapping("/customer")
    public String sayHello () {
        return "Hello everyone";
    }

    @GetMapping("/{ID}")
    public ResponseEntity<BookDataModel.UserDataModel> getTutorialById(@PathVariable("ID") int ID) {
        BookDataModel.UserDataModel userDataModel = interfaceChoice.findById(ID);

        if (userDataModel != null) {
            return new ResponseEntity<>(userDataModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/test")
    public ResponseEntity<String> createTutorial(@RequestBody BookDataModel.UserDataModel userDataModel) {
        try {
            interfaceChoice.save(new BookDataModel.UserDataModel(userDataModel.getUserName(), userDataModel.getUserPassword(), userDataModel.getFullName(),
                    userDataModel.getEmail(), userDataModel.getAddress(), userDataModel.getCreditCard()));
            return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
