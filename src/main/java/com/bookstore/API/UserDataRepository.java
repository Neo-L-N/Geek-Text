package com.bookstore.API;

import com.bookstore.API.BookSortingFeature.BookDataModel;

import java.util.List;

public interface UserDataRepository {

    List<BookDataModel> findGenre(String genre);

    List<BookDataModel> sortRating(Integer rating);

    List<BookDataModel> bestSeller();

    void updatePrice(String publisher, Integer discount);

    BookDataModel.UserDataModel findById(int userID);

    int save(BookDataModel.UserDataModel userDataModel);


}
