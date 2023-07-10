package com.bookstore.API.Services;

import com.bookstore.API.Models.BookDataModel;

import java.util.List;

public interface BrowsingSortingService {

    List<BookDataModel> findGenre(String genre);

    List<BookDataModel> sortRating(Integer rating);

    List<BookDataModel> bestSeller();

    void updatePrice(String publisher, Integer discount);


}
