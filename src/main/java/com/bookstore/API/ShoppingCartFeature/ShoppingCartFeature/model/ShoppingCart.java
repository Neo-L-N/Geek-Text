package ShoppingCartFeature.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @Column(name = "cart_id")
        private String cartId;
    @Column
        private String userId;
    @Column
        private BigDecimal subtotal;

        public String getCartId()
        {
            return cartId;
        }

        public void setCartId(String cartId)
        {
            this.cartId = cartId;
        }

        public String getUserId()
        {
            return userId;
        }

        public void setUserId(String userId)
        {
            this.userId = userId;
        }

        public BigDecimal getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(BigDecimal subtotal) {
            this.subtotal = subtotal;
        }
}
