package com.example.restapi.service;
import java.math.*;
import java.util.*;
import com.example.restapi.model.CartItemModel;
import com.example.restapi.model.ShoppingCartModel;
import org.springframework.stereotype.Service;
import com.example.restapi.repo.ShoppingCartRepo;
import com.example.restapi.repo.CartItemRepo;
import java.io.FileNotFoundException;
@Service
public class ShoppingCartService {
    private final ShoppingCartRepo cartRepository;
    private final CartItemRepo cartItemRepository;

    public ShoppingCartService(ShoppingCartRepo cartRepository, CartItemRepo cartItemRepository)
    {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public ShoppingCartModel getCartByUserId(String userId) throws FileNotFoundException {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new FileNotFoundException("Cart not found for user: " + userId));
    }

    public List<CartItemModel> getCartItems(String cartId)
    {
        return cartItemRepository.findByCartId(cartId);
    }

    public CartItemModel addItemToCart(String cartId, String bookId)
    {

        CartItemModel cartItem = new CartItemModel();
        cartItem.setCartId(cartId);
        cartItem.setBookId(bookId);

        return cartItemRepository.save(cartItem);
    }

    public void removeItemFromCart(String cartItemId) throws FileNotFoundException
    {
        if (!cartItemRepository.existsById(cartItemId)) {
            throw new FileNotFoundException("Cart item not found: " + cartItemId);
        }
        cartItemRepository.deleteById(cartItemId);
    }

    public BigDecimal calculateSubtotal(String cartId) {
        List<CartItemModel> cartItems = cartItemRepository.findByCartId(cartId);
        BigDecimal subtotal = BigDecimal.ZERO;

        for (CartItemModel item : cartItems) {
            BigDecimal price = item.getPrice();
            subtotal = subtotal.add(price);
        }

        return subtotal;
    }
}
