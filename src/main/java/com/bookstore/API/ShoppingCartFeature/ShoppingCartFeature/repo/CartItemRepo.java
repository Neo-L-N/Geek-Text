
package ShoppingCartFeature.repo;
import java.util.*;

//import ShoppingCartFeature.model.BookData;
import ShoppingCartFeature.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "cartItemRepository")
public interface CartItemRepo extends JpaRepository<CartItem, Long>
{
    List<CartItem> findByCartId(String cartId);
  //  Optional<CartItem> findByUserIdAndBookId(String userId, Long bookId);


}