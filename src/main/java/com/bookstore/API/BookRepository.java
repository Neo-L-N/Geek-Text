package com.bookstore.API;


import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends UserDataRepository<BookDataModel, Long> {
    // You can define custom query methods here if needed
    List<BookDataModel> findByGenre(String genre);

    List<BookDataModel> findAll();

    Optional<BookDataModel> findById(Long id);
}
