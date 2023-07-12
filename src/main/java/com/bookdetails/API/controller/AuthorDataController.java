package com.bookdetails.API.controller;

import com.bookdetails.API.model.AuthorData;

import com.bookdetails.API.repository.AuthorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http:localhost/3036")
@RestController
@ResponseBody
@RequestMapping("/api")

public class AuthorDataController {
    @Autowired
    AuthorDataRepository authorRepository;

    @PostMapping("/AuthorData")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorData author) {
        try{
            authorRepository.save(new AuthorData(author.getfirstname(), author.getlastname(), author.getBiography(), author.getPublisher(),
                                                                                                                author.getauthorid()));
            return new ResponseEntity<>("Author was added successfully.",  HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
