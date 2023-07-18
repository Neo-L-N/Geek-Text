package ShoppingCartFeature.controller;
import ShoppingCartFeature.model.CartItem;
import ShoppingCartFeature.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final ShoppingCartService cartService;

    @Autowired
    public CartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String greeting()
    {
        return "Hello User.";
    }

    @GetMapping("/{cartId}")
    public List<CartItem> getCartItems(@PathVariable String cartId) {
        return cartService.getCartItems(cartId);
    }

    @GetMapping("/{cartId}/subtotal")
    public BigDecimal calculateSubtotal(@PathVariable String cartId) {
        return cartService.calculateSubtotal(cartId);
    }

    @PostMapping("/{cartId}/items")
    public CartItem addItemToCart(@PathVariable String cartId, @RequestBody String bookId) {
        return cartService.addItemToCart(cartId, bookId);
    }

    @DeleteMapping("/items/{cartItemId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable String cartItemId) throws FileNotFoundException {
        cartService.removeItemFromCart(cartItemId);
        return ResponseEntity.ok("Cart item removed successfully");
    }


}
