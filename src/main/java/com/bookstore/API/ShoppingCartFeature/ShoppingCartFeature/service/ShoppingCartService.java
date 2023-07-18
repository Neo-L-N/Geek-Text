package ShoppingCartFeature.service;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import ShoppingCartFeature.model.CartItem;
import ShoppingCartFeature.repo.ShoppingCartRepo;
import ShoppingCartFeature.repo.CartItemRepo;

import java.io.FileNotFoundException;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepo shoppingCartRepository;
    private final CartItemRepo cartItemRepository;

    public ShoppingCartService(ShoppingCartRepo shoppingCartRepository, CartItemRepo cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
    }


    public List<CartItem> getCartItems(String cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    public CartItem addItemToCart(String cartId, String bookId) {
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cartId);
        cartItem.setBookId(bookId);

        return cartItemRepository.save(cartItem);
    }

    public void removeItemFromCart(String cartItemId) throws FileNotFoundException {
        if (!cartItemRepository.existsById(cartItemId)) {
            throw new FileNotFoundException("Cart item not found: " + cartItemId);
        }
        cartItemRepository.deleteById(cartItemId);
    }

    public BigDecimal calculateSubtotal(String cartId) {
        List<CartItem> cartItems = cartItemRepository.findByCartId(cartId);
        BigDecimal subtotal = BigDecimal.ZERO;

        for (CartItem item : cartItems) {
            BigDecimal price = item.getPrice();
            subtotal = subtotal.add(price);
        }

        return subtotal;
    }
}
