package com.bookstore.API;

import java.util.List;

public interface UserDataRepository {

    UserDataModel findById(int userID);

    int save(UserDataModel userDataModel);

    //////// book data

    List<BookDataModel> findGenre(String genre);

    List<BookDataModel> sortRating();

    List<BookDataModel> bestSeller();

}
