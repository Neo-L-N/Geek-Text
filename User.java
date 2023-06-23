package com.bookstore.profilemanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<CreditCard> creditCards;

    // Constructors, getters, and setters
    //edit column + string to priv?
    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }
    String getUsername() {
        return username;
    }

    @Column public String getName() {
        return name;
    }

    @Column public String getEmail() {
        return email;
    }

    @Column public String getAddress() {
        return address;
    }

    @Column public void setName(String name) {
        this.name = name;
    }

    @Column public void setEmail(String email) {
        this.email = email;
    }

    @Column public void setAddress(String address) {
        this.address = address;
    }
}
