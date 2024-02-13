package com.example.shoppingcart.Controllers;

import com.example.shoppingcart.Repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartController {
    private final ShoppingCartRepository cartRepository;

    public ShoppingCartController(ShoppingCartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
