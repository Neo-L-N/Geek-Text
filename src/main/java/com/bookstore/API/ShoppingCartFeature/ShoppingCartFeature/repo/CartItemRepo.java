
package ShoppingCartFeature.repo;
import java.util.*;
import ShoppingCartFeature.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "cartItemRepository")
public interface CartItemRepo extends JpaRepository<CartItem, String>
{
    List<CartItem> findByCartId(String cartId);

}