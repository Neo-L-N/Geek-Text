package ShoppingCartFeature.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @Column
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
