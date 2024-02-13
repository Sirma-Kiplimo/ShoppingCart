package com.example.shoppingcart.services;

import com.example.shoppingcart.Repositories.ShoppingCartRepository;
import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void addProductToCart(Long cartId, Product product) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.addProduct(product);
        cartRepository.save(cart);
    }

    public List<Product> getProductsInCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        return new ArrayList<>(cart.getProducts());
    }

}
