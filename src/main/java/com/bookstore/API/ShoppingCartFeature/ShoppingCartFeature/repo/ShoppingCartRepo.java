package ShoppingCartFeature.repo;

import ShoppingCartFeature.model.ShoppingCart;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository(value = "shoppingCartRepository")
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, String> {

    Optional<ShoppingCart> findByUserId(String userId);

    @Query("SELECT SUM(item.price) FROM CartItem item WHERE item.cartId = :cartId")
    BigDecimal calculateSubtotalByCartId(@Param("cartId") String cartId);
}
