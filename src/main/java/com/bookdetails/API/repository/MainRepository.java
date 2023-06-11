package com.bookdetails.API.repository;

import com.bookdetails.API.model.BookDetails;

import java.util.List;


public interface MainRepository {
    int save(BookDetails book);

    int update(BookDetails book);

    BookDetails findByIsbn(int isbn);

    int deleteByIsbn(int isbn);

    List<BookDetails> findAll();

    List<BookDetails> findByPublished(boolean published);

    List<BookDetails> findByTitleContaining(String title);

    int deleteAll();

}
