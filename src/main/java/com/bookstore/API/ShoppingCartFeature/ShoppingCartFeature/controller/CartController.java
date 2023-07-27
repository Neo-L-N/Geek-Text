package ShoppingCartFeature.controller;
//import ShoppingCartFeature.model.BookData;
import ShoppingCartFeature.model.CartItem;
import ShoppingCartFeature.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final ShoppingCartService cartService;

    @Autowired
    public CartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("")
    public String greeting()
    {
        return "Hello User.";
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCartItems(@PathVariable String userId) {
        return cartService.getCartItems(userId);
    }


    @GetMapping("/{userId}/subtotal")
    public BigDecimal calculateSubtotal(@PathVariable String userId) {
         return cartService.getSubtotalByUserId(userId);

    }


    @PostMapping("/{userId}/addItem")
    public CartItem addItemToCart(@PathVariable String userId, @RequestParam Long bookId) {
        System.out.println(userId);
       return cartService.addItemToCart(userId, bookId);
    }


    @DeleteMapping("/{userId}/delete")
    public boolean removeItemFromCart(@PathVariable String userId, @RequestParam Long bookId) {
    return cartService.removeItemFromCart(userId, bookId);
    }


}
