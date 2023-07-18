package com.bookdetails.API.BookDetailsFeature.repository;

import com.bookdetails.API.BookDetailsFeature.model.BookDetails;

import java.util.List;


public interface BookDetailsRepository {
    int save(BookDetails book);

    int update(BookDetails book);

    BookDetails findByIsbn(String isbn);

    String deleteByIsbn(String isbn);

    List<BookDetails> findAll();
    List<BookDetails> findByTitleContaining(String title);
    List<BookDetails> findAllByAuthorID(int authorid);

    int deleteAll();

}
