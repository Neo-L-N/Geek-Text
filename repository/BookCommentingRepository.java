package com.geektext.api.repository;

import com.geektext.api.model.BookCommenting;
import java.util.List;

/* BookCommenting Repository is an interface that provides abstract methods for CRUD operations such as save and custom
finder methods such as findByPublished.
 */
public interface BookCommentingRepository
{
    int save(BookCommenting Book);
    int update(BookCommenting Book)
    BookCommenting findById(long id);
    int deleteById(long id);

    List<BookCommenting> findAll();
    List<BookCommenting> findByPublished(boolean published);
    List<BookCommenting> findByTitleContaining(String title);
    int deleteAll();

}
