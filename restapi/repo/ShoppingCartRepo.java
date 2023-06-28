package com.example.restapi.repo;
import java.util.*;
import com.example.restapi.model.ShoppingCartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCartModel, String>
{
    Optional<ShoppingCartModel> findByUserId(String userId);
}