package ShoppingCartFeature.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cart_item")
public class CartItem {
        @Column(name = "cart_id")
        private String cartId;
        @Column
        private Long bookId;
        @Column
        private BigDecimal price;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "item_id")
        private Long itemId;

        @Column
        private String title;
        @Column
        private String author;
        @Column
        private String ISBN;

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getISBN() {
                return ISBN;
        }

        public void setISBN(String ISBN) {
                this.ISBN = ISBN;
        }

        public String getCartId()
        {
            return cartId;
        }

        public void setCartId(String cartId)
        {
            this.cartId = cartId;
        }

        public Long getBookId()
        {
            return bookId;
        }

        public void setBookId(Long bookId)
        {
            this.bookId = bookId;
        }

        public Long getItemId()
        {
            return itemId;
        }

        public void setItemId(Long itemId)
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

