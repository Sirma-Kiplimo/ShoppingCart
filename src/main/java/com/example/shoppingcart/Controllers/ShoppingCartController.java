package com.example.shoppingcart.Controllers;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
public class ShoppingCartController {
    private final ShoppingCartService cartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

//    creating a cart
    @PostMapping("/create")
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart();
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

//    Adding Items to the cart
    @PostMapping("/{cartId}/add")
    public ResponseEntity<Void> addProductToCart(@PathVariable Long cartId, @RequestBody Product product) {
        cartService.addProductToCart(cartId, product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    Displaying items in the cart
    @GetMapping("/{cartId}/products")
    public ResponseEntity<List<Product>> getProductsInCart(@PathVariable Long cartId) {
        List<Product> products = cartService.getProductsInCart(cartId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


//    Removing items in a cart
    @DeleteMapping("/{cartId}/remove/{procuctId}")
    public ResponseEntity<Void> removeProcuctFromCart(@PathVariable Long cartId, @PathVariable Long procuctId) {
        cartService.removeProcuctFromCart(cartId, procuctId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    calculating the total price of the items in the cart
    @GetMapping("/{cartId}/total")
    public ResponseEntity<Double> getTotalPrice(@PathVariable Long cartId) {
        double total = cartService.calculateTotalPrice(cartId);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

}
