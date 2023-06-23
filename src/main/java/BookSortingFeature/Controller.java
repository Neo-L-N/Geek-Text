package BookSortingFeature;

import BookSortingFeature.BookDataModel;
import BookSortingFeature.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller must be in the same package directory

@RestController // contains all the methods
public class Controller {

    @Autowired
    UserDataRepository interfaceChoice;

    @GetMapping("/gen/{genre}") // genre variable
    // This gets a list of books by the user specified genre
    public List<BookDataModel> findBookGenre(@PathVariable("genre") String genre) {

        List<BookDataModel> bookDataModels = interfaceChoice.findGenre(genre);

        return bookDataModels; // returns the list of books
    }

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
