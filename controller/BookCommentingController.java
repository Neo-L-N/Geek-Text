package com.geektext.api.controller;

import com.geektext.api.model.BookCommenting;
import com.geektext.api.repository.BookCommentingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origin = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class BookCommentingController
{
    @Autowired
    BookCommentingRepository bookCommentingRepository;

    @GetMapping("/bookCommenting")
    public ResponseEntity<List<BookCommenting>> getAllBookCommenting(@RequestParam(required = false) String title)
    {
        try
        {
            List<BookCommenting> bookCommenting = new ArrayList<BookCommenting>();
            if (title == null)
                BookCommentingRepository.findByTitleContaining(title).forEeach(bookCommenting::add);

            if (bookCommenting.isEmpty()) {
                return new ReponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookCommenting, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bookCommenting/{id}")
    public ResponseEntity<BookCommenting> getBookCommentingById(@PathVariable("id") long id)
    {
        BookCommenting bookCommenting = bookCommentingRepository.findById(id);

        if (bookCommenting != null) {
            return new ResponseEntity<>(bookCommenting, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/bookCommenting")
    public ResponseEntity<String> createBookCommenting(@RequestBody BookCommenting bookCommenting)
    {
        try {
            bookCommentingRepository.save(new BookCommenting(bookCommenting.getTitle(), bookCommenting.getComment(),
                    bookCommenting.getTimestamp(), false));
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERVAL_SERVER_ERROR);
        }
    }

    @PutMapping("/bookCommenting/{id}")
    public ResponseEntity<String> updateBookCommenting(@PathVariable("id") long id, @RequestBody BookCommenting bookCommenting)
    {
        BookCommenting _bookCommenting = bookCommentingRepository.findById(id);

        if (_bookCommenting != null)
        {
            _bookCommenting.setId(id);
            _bookCommenting.setTitle(bookCommenting.getTitle());
            _bookCommenting.setComment(bookCommenting.getComment());
            _bookCommenting.setTimestamp(bookCommenting.getTimestamp());

            bookCommentingRepository.update(_bookCommenting);
            return new ResponseEntity<>("Book Commenting was updated successfully.", HttpStatus.OK);
        }
        else {
            
        }
    }
    @DeleteMapping
}
