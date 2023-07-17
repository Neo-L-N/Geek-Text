package com.geektext.api.controller;

import com.geektext.api.model.BookCommenting;
import com.geektext.api.model.BookRating;
import com.geektext.api.repository.BookCommentingRepository;
import com.geektext.api.repository.BookRatingRepository;
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

public class BookRatingController {
    @Autowired
    BookRatingRepository bookRatingRepository;

    @GetMapping("/bookRating")
    public ResponseEntity<List<BookRating>> getAllBookRating(@RequestParam(required = false) String title)
    {
        try
        {
            List<BookRating> bookRating = new ArrayList<BookRating>();
            if (title == null)
                BookRatingRepository.findByTitleContaining(title).forEeach(bookRating::add);

            if (bookRating.isEmpty()) {
                return new ReponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookRating, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/bookRating/{id}")
    public ResponseEntity<BookRating> getBookRatingById(@PathVariable("id") long id)
    {
        BookRating bookRating = bookRatingRepository.findById(id);

        if (bookRating != null) {
            return new ResponseEntity<>(bookRating, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/bookRating")
    public ResponseEntity<String> createBookRating(@RequestBody BookRating bookRating)
    {
        try {
            bookRatingRepository.save(new BookRating(bookRating.getTitle(), bookRating.getRating(),
                    bookRating.getAverageRating(), bookRating.getTimestamp(), false);

        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERVAL_SERVER_ERROR);
        }
    }
    @PutMapping("/bookRating/{id}")
    public ResponseEntity<String> updateBookRating(@PathVariable("id") long id, @RequestBody BookRating bookRating)
    {
        BookRating _bookRating = bookRatingRepository.findById(id);

        if (_bookRating != null)
        {
            _bookRating.setId(id);
            _bookRating.setTitle(bookRating.getTitle());
            _bookRating.setRating(bookRating.getRating());
            _bookRating.setAverageRating(bookRating.getAverageRating());
            _bookRating.setTimestamp(bookRating.getTimestamp());

            bookRatingRepository.update(_bookRating);
            return new ResponseEntity<>("Book Rating was updated successfully.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Cannot find BookRating with id =" + id, HttpaStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/bookRating/{id}")
    public ResponseEntity<String>deleteBookRating(@PathVariable("id") long id){
        try{
            int result = bookRatingRepository.deleteById(id);
            if (result == 0){
                return new ResponseEntity<>("Cannot find BookRating with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("BookRating was deleted successfully.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Cannot delete bookRating", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/bookRating")
    public ResponseEntity<String>deleteAllBookRating(){
        try{
            int numRows = bookRatingRepository.deleteAll();
            return new ResponseEntity<>("Deleted " + numRows + "BookRating(s) successfully.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Cannot delete bookRating.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/bookRating/published")
    public ResponseEntity<List<BookRating>> findByPublished(){
        try{
            List<BookRating> bookRating = bookRatingRepository.findByPublished(true);

            if (bookRating.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookRating, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
