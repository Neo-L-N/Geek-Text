package ShoppingCartFeature.service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//import ShoppingCartFeature.model.BookData;
import ShoppingCartFeature.model.ShoppingCart;
import org.springframework.stereotype.Service;
import ShoppingCartFeature.model.CartItem;
import ShoppingCartFeature.repo.ShoppingCartRepo;
import ShoppingCartFeature.repo.CartItemRepo;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepo shoppingCartRepository;
    private final CartItemRepo cartItemRepository;

    public ShoppingCartService(ShoppingCartRepo shoppingCartRepository, CartItemRepo cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getCartItems(String userId) {
        String cartId = getCartIdByUserId(userId);
        return cartItemRepository.findByCartId(cartId);
    }

    public Optional<ShoppingCart> getCartByUserId(String userId) {
        return shoppingCartRepository.findByUserId(userId);
    }

    public String findUserIdByCartId(String cartId) {
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findById(cartId);
        if (optionalCart.isPresent()) {
            ShoppingCart cart = optionalCart.get();
            return cart.getUserId();
        } else {
            return null;
        }
    }

    public String getCartIdByUserId(String userId) {
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findByUserId(userId);
        if (optionalCart.isPresent()) {
            ShoppingCart cart = optionalCart.get();
            return cart.getCartId();
        } else {
            return null;
        }
    }

    public ShoppingCart createCart(String userId) {
        Optional<ShoppingCart> existingCart = shoppingCartRepository.findByUserId(userId);
        if (existingCart != null) {
            return null;
        }

        ShoppingCart newCart = new ShoppingCart();
        newCart.setUserId(userId);

        newCart = shoppingCartRepository.save(newCart);

        return newCart;
    }

    public CartItem addItemToCart(String userId, Long bookId) {


        CartItem cartItem = new CartItem();
        cartItem.setCartId(getCartIdByUserId(userId));
        cartItem.setBookId(bookId);
        cartItem.setAuthor("Ritten");
        cartItem.setPrice(BigDecimal.valueOf(25.00));
        cartItem.setTitle("Intro to Java");
        cartItem.setISBN("314432154852058");

        logSubtotal(userId);
        return cartItemRepository.save(cartItem);
    }



  /*  public void removeItemFromCart(String cartItemId) throws FileNotFoundException {
        if (!cartItemRepository.existsById(cartItemId)) {
            throw new FileNotFoundException("Cart item not found: " + cartItemId);
        }
        cartItemRepository.deleteById(cartItemId);
        }
   */


    public BigDecimal calculateSubtotal(String cartId) {
        List<CartItem> cartItems = cartItemRepository.findByCartId(cartId);
        BigDecimal subtotal = BigDecimal.ZERO;

        for (CartItem item : cartItems) {
            BigDecimal price = item.getPrice();
            subtotal = subtotal.add(price);
        }


        return subtotal;
    }

    public void logSubtotal(String userId) {
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findByUserId(userId);
        if (optionalCart.isPresent()) {
            ShoppingCart cart = optionalCart.get();

            BigDecimal subtotal = calculateSubtotal(cart.getCartId());

            cart.setSubtotal(subtotal);

            shoppingCartRepository.save(cart);
        }
    }

    public BigDecimal getSubtotalByUserId(String userId) {
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findByUserId(userId);

        logSubtotal(userId);

        ShoppingCart shoppingCart = optionalCart.orElseThrow(() -> new NoSuchElementException("Cart not found for user: " + userId));

        BigDecimal subtotal = shoppingCart.getSubtotal();

        return subtotal;
    }

    public boolean removeItemFromCart(String userId, Long bookId)
    {

        cartItemRepository.deleteById(Long.valueOf(userId));
        return true;
    }

}
