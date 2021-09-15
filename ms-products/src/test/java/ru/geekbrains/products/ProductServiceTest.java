package ru.geekbrains.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.products.entities.Product;
import ru.geekbrains.products.repository.ProductRepository;
import ru.geekbrains.products.services.ProductService;

import java.util.Optional;

@SpringBootTest(classes = ProductService.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testGetProduct() {
        Product testProduct = new Product();
        testProduct.setTitle("Snickers");
        testProduct.setPrice(50);
        testProduct.setId(10L);

        Mockito
                .doReturn(Optional.of(testProduct))
                .when(productRepository)
                .findById(10L);

        Product p = productService.findProductById(10L).get();
        Mockito.verify(productRepository, Mockito.times(1)).findById(ArgumentMatchers.eq(10L));
        Assertions.assertEquals("Snickers", p.getTitle());
    }
}
