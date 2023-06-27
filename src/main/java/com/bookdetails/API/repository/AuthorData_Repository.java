package com.bookdetails.API.repository;

import com.bookdetails.API.model.AuthorData;
public interface AuthorData_Repository {

    int save(AuthorData author);
    //int update(authorData author);
    AuthorData findByID(int authorID);

}
