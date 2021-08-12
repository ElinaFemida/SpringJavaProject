package ru.geekbrins.store.model.entities;

<<<<<<< HEAD
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

=======

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
>>>>>>> lesson_12

@NoArgsConstructor
@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
<<<<<<< HEAD

=======
>>>>>>> lesson_12
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

<<<<<<< HEAD
    @Column(name = "cost_per_product")
    private double costPerProduct;

    @Column(name = "cost")
    private double price;

    public OrderItem(Product product){
        this.product = product;
        this.quantity = 1;
        this.costPerProduct = product.getPrice();
        this.price = this.costPerProduct;
    }

    public void incrementQuantity(){
        quantity++;
        price = quantity * costPerProduct;
    }

    public void decrementQuantity(){
        quantity--;
        price = quantity * costPerProduct;
    }
}
=======
    @Column(name = "price_per_product")
    private int pricePerProduct;

    @Column(name = "price")
    private int price;

    public OrderItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.pricePerProduct = product.getPrice();
        this.price = this.pricePerProduct;
    }

    public void incrementQuantity() {
        quantity++;
        price = quantity * pricePerProduct;
    }

    public void decrementQuantity() {
        quantity--;
        price = quantity * pricePerProduct;
    }
}
>>>>>>> lesson_12
