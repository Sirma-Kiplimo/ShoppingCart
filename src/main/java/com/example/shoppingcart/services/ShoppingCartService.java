package com.example.shoppingcart.services;

import com.example.shoppingcart.Repositories.ShoppingCartRepository;
import com.example.shoppingcart.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository cartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }
}
