package com.bookstore.API;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    private final List<BookDataModel> wishlist;

    @Autowired
    public WishlistController() {
        this.wishlist = new ArrayList<>();
    }

    @GetMapping
    public List<BookDataModel> getWishlist() {
        return wishlist;
    }

    @PostMapping
    public BookDataModel addToWishlist(@RequestBody BookDataModel item) {
        wishlist.add(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public BookDataModel removeFromWishlist(@PathVariable long id) {
        BookDataModel itemToRemove = wishlist.stream()
                .filter(item -> item.getAuthorid() == id)
                .findFirst()
                .orElse(null);

        if (itemToRemove != null) {
            wishlist.remove(itemToRemove);
        }

        return itemToRemove;
    }
}

