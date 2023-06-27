package com.bookdetails.API.controller;

import com.bookdetails.API.model.BookDetails;
import com.bookdetails.API.repository.BookDetails_MainRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3036")
@RestController
@ResponseBody
@RequestMapping("/api")
public class BookDetailsController {

    @Autowired
    BookDetails_MainRepository mainRepository;

    @GetMapping("/BookDetails")
    public ResponseEntity<List<BookDetails>> getAllBooks(@RequestParam(required = false) String title) {
        try {
            List<BookDetails> Books = new ArrayList<BookDetails>();

            if (title == null)
                mainRepository.findAll().forEach(Books::add);
            else
                mainRepository.findByTitleContaining(title).forEach(Books::add);

            if (Books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(Books, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/BookDetails/{ISBN}")
    public ResponseEntity<BookDetails> getBookByIsbn(@PathVariable("ISBN") String isbn) {
        BookDetails book = mainRepository.findByIsbn(isbn);

        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/BookDetails")
    public ResponseEntity<String> createBook(@RequestBody BookDetails book) {
        try {
            mainRepository.save(new BookDetails(book.getauthorid(), book.getTitle(), book.getDescript(), book.getIsbn(), book.getPrice(), book.getPubYear(),
                    book.getSold(), book.getbookid(), book.getGenre(), book.getPublisher(), book.getRating()));
            return new ResponseEntity<>("Book was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/BookDetails/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable("ISBN") String isbn) {
        try {
            String result = mainRepository.deleteByIsbn(isbn);
            if (result == null) {
                return new ResponseEntity<>("Cannot find Book with isbn=" + isbn, HttpStatus.OK);
            }
            return new ResponseEntity<>("Book was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete book.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/BookDetails/{isbn}")
    public ResponseEntity<String> updateBook(@PathVariable("ISBN") String isbn, @RequestBody BookDetails book) {
        BookDetails _tutorial = mainRepository.findByIsbn(isbn);

        if (_tutorial != null) {
            _tutorial.setIsbn(isbn);
            _tutorial.setTitle(book.getTitle());
            _tutorial.setDescript(book.getDescript());
            //_tutorial.setPublished(book.isPublished());

            mainRepository.update(_tutorial);
            return new ResponseEntity<>("Book was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Book with isbn=" + isbn, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/BookDetails")
    public ResponseEntity<String> deleteAllBooks() {
        try {
            int numRows = mainRepository.deleteAll();
            return new ResponseEntity<>("Deleted " + numRows + " Book(s) successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete books.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
    @GetMapping("/tutorials/published")
    public ResponseEntity<List<BookDetails>> findByPublished() {
        try {
            List<BookDetails> Books = mainRepository.findByPublished(true);

            if (Books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


     */
}