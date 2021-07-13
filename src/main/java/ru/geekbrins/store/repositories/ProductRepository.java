package ru.geekbrins.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrins.store.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByName (String title);

    Optional<Product> findAllByCostGreaterThanAndCostLessThan(double min, double max);

    Optional<Product> findAllByCostGreaterThanEqual(double min);

    Optional<Product> findAllByCostLessThanEqual(double max);



}