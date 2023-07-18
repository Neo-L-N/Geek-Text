package com.bookstore.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller must be in the same package directory

@RestController // contains all the methods
public class Controller {

    @RequestMapping("/customer")
    public String sayHello () {
        return "Hello everyone";
    }


    @Autowired
    UserDataRepository interfaceChoice;

    @GetMapping("/{ID}")
    public ResponseEntity<UserDataModel> getTutorialById(@PathVariable("ID") int ID) {
        UserDataModel userDataModel = interfaceChoice.findById(ID);

        if (userDataModel != null) {
            return new ResponseEntity<>(userDataModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/test")
    public ResponseEntity<String> createTutorial(@RequestBody UserDataModel userDataModel) {
        try {
            interfaceChoice.save(new UserDataModel(userDataModel.getUserName(), userDataModel.getUserPassword(), userDataModel.getFullName(),
                    userDataModel.getEmail(), userDataModel.getAddress(), userDataModel.getCreditCard()));
            return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //////////

    @GetMapping("/gen/{genre}")
    public List<BookDataModel> findBookGenre(@PathVariable("genre") String genre) {
        List<BookDataModel> bookDataModels = interfaceChoice.findGenre(genre);

        return bookDataModels;
    }

    @GetMapping("/rating")
    public List<BookDataModel> sortRating() {
        List<BookDataModel> bookDataModels = interfaceChoice.sortRating();

        return bookDataModels;
    }

    @GetMapping("/sold")
    public List<BookDataModel> bestSeller() {
        List<BookDataModel> bookDataModels = interfaceChoice.bestSeller();

        return bookDataModels;
    }

}
