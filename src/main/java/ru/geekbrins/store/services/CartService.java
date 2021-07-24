package ru.geekbrins.store.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrins.store.model.entities.Cart;
import ru.geekbrins.store.model.entities.Product;

@Service
@RequiredArgsConstructor
public class CartService {

    private Cart cart;

    public Cart addProduct(Product product){
        cart.getUserProducts().add(product);
        return cart;
    }

    public Cart deleteProduct (Product product){
        cart.getUserProducts().remove(product);
        return cart;
    }
}