
package com.example.restapi.repo;
import java.util.*;
import com.example.restapi.model.CartItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository<CartItemModel, String>
{
    List<CartItemModel> findByCartId(String cartId);

}