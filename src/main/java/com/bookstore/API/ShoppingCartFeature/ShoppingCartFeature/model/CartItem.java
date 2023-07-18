package ShoppingCartFeature.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cart_item")
public class CartItem {
        @Column
        private String cartId;
        @Column
        private String bookId;
        @Id
        @Column
        private String itemId;
        @Column
        private BigDecimal price;

        public String getCartId()
        {
            return cartId;
        }

        public void setCartId(String cartId)
        {
            this.cartId = cartId;
        }

        public String getBookId()
        {
            return bookId;
        }

        public void setBookId(String bookId)
        {
            this.bookId = bookId;
        }

        public String getItemId()
        {
            return itemId;
        }

        public void setItemId(String itemId)
        {
            this.itemId = itemId;
        }
        public BigDecimal getPrice()
        {
        return price;
        }
        public void setPrice(BigDecimal price)
        {
        this.price = price;
        }
}

