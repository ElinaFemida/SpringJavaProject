package ru.geekbrins.store.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrins.store.model.entities.Cart;
import ru.geekbrins.store.model.entities.Product;
import ru.geekbrins.store.services.CartService;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PutMapping
    public Cart updateProduct(@RequestBody Product product) {
        return cartService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void updateProduct(@PathVariable Product product) {
        cartService.deleteProduct(product);
    }
}
