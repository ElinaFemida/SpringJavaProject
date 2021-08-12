package ru.geekbrins.store.model.entities;

import lombok.Data;
import java.util.List;
@Data
public class Cart {

    private List<Product> userProducts;

}
