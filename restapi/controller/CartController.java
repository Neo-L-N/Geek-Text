package com.example.restapi.controller;
import com.example.restapi.model.CartItemModel;
import com.example.restapi.model.ShoppingCartModel;
import com.example.restapi.service.ShoppingCartService;
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
    public CartController(ShoppingCartService cartService)
    {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String greeting() {
        return "Hello User.";
    }

    @GetMapping(value = "/{userId}")
    public ShoppingCartModel getCartByUserId(@PathVariable String userId) throws FileNotFoundException
    {
        return cartService.getCartByUserId(userId);
    }

    @GetMapping(value = "/{cartId}/items")
    public List<CartItemModel> getCartItems(@PathVariable String cartId)
    {
        return cartService.getCartItems(cartId);
    }

    @GetMapping(value = "/{cartId}/subtotal")
    public BigDecimal calculateSubtotal(@PathVariable String cartId)
    {
        return cartService.calculateSubtotal(cartId);
    }

    @PostMapping(value = "/{cartId}/items")
    public CartItemModel addItemToCart(@PathVariable String cartId, @RequestBody String bookId)
    {
        return cartService.addItemToCart(cartId, bookId);
    }

    @DeleteMapping(value = "/items/{cartItemId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable String cartItemId) throws FileNotFoundException
    {
        cartService.removeItemFromCart(cartItemId);
        return ResponseEntity.ok("Cart item removed successfully");
    }
}
