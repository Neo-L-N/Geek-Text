package com.bookstore.profilemanagement;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userRepository.createUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userRepository.getUser(username);
    }

    @PutMapping("/{username}")
    public void updateUser(@PathVariable String username, @RequestBody User updatedUser) {
        userRepository.updateUser(username, updatedUser);
    }

    @PostMapping("/{username}/credit-cards")
    public void createCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
        userRepository.createCreditCard(username, creditCard);
    }
}
