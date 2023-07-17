package com.geektext.api.repository;

import com.geektext.api.model.BookRating;
import java.util.List;

/* BookRating Repository is an interface that provides abstract methods for CRUD operations such as save and custom
finder methods such as findByPublished.
 */
public interface BookRatingRepository
{
    int save(BookRating Book);
    int update(BookRating Book)
    BookRating findById(long id);
    int deleteById(long id);

    List<BookRating> findAll();
    List<BookRating> findByPublished(boolean published);
    List<BookRating> findByTitleContaining(String title);
    int deleteAll();
}
