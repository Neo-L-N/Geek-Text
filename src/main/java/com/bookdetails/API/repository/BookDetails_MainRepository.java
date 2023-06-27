package com.bookdetails.API.repository;

import com.bookdetails.API.model.BookDetails;

import java.util.List;


public interface BookDetails_MainRepository {
    int save(BookDetails book);

    int update(BookDetails book);

    BookDetails findByIsbn(String isbn);

    String deleteByIsbn(String isbn);

    List<BookDetails> findAll();
    List<BookDetails> findAllByID(int authorid);


    List<BookDetails> findByTitleContaining(String title);

    int deleteAll();

}
