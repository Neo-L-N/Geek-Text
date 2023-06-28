package com.example.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;
@Entity
public class ShoppingCartModel {

    @Id
    @Column
        private String cartId;
    @Column
        private String userId;

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
    }
