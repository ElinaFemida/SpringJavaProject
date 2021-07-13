package ru.geekbrins.store.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrins.store.entities.Product;
import ru.geekbrins.store.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
    @GetMapping("/product_title")
    public Optional<Product> findProductByName (@RequestParam String title) {
        return productRepository.findProductByName(title);
    }

    @GetMapping("/cost")
    public Optional<Product> getProductGreaterAndLessThan(@RequestParam Double min, @RequestParam Double max){
        return productRepository.findAllByCostGreaterThanAndCostLessThan(min, max);
    }

    @GetMapping("/cost_greater_than")
    public Optional<Product> getProductGreaterThan(@RequestParam Double min) {
        return productRepository.findAllByCostGreaterThanEqual(min);
    }

    @GetMapping("/cost_less_than")
    public Optional<Product> getProductLessThan(@RequestParam Double max) {
        return productRepository.findAllByCostLessThanEqual(max);
    }
}


