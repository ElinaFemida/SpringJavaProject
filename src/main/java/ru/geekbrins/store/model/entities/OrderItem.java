package ru.geekbrins.store.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@NoArgsConstructor
@Data
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

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