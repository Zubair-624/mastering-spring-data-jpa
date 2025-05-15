package com.springdatajpa.masteringspringdatajpa.repository;

import com.springdatajpa.masteringspringdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
//import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void saveTestMethod(){

        String dynamicSku = "iphone" + System.currentTimeMillis();

        //create product object
        Product product = Product.builder()
                .name("Iphone 6")
                .description("This is an Iphone 6 product")
                .sku(dynamicSku)
                .price(new BigDecimal(200))
                .active(true)
                .imageUrl("iphone.png")
                .build();

        //save product object in the database
        Product savedProductObject = productRepository.save(product);

        //display the product information
        System.out.println(savedProductObject.getId());
        System.out.println(savedProductObject.toString());

    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateTestMethod(){

        //find or retrieve on entity by id
        Long id = 1L;

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found" + id));

        //Update entity information
        product.setName("iphone 7");
        product.setDescription("This is an iphone 7 product");

        //save updated entity
        Product updatedProduct = productRepository.save(product);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void findByIdTestMethod(){

        Long id = 4L;

        Product findByIdProduct = productRepository.findById(id).get();
    }

    @Test
    @Transactional
    @Rollback(false)
    public void saveAllTestMethod(){

        String dynamicSku = "iphone" + System.currentTimeMillis();

        //Create product
        Product product = Product.builder()
                .name("Iphone 7")
                .description("This is an Iphone 7")
                .sku(dynamicSku)
                .price(new BigDecimal(500))
                .active(true)
                .imageUrl("ihone 7.ing")
                .build();

        Product product3 = Product.builder()
                .name("Iphone 8")
                .description("This is an Iphone 8")
                .sku(dynamicSku)
                .price(new BigDecimal(600))
                .active(true)
                .imageUrl("iphone 8.ing")
                .build();

        List<Product> SaveAllProducts = productRepository.saveAll(List.of(product, product3));
    }


    @Test
    @Transactional
    @Rollback(false)
    public void findAllTestMethod(){

        List<Product> products = productRepository.findAll();

        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }

    @Test
    @Transactional
    @Rollback(false)
    void deleteByIdTestMethod(){

        Long id = 4L;

        productRepository.deleteById(id);
    }

    @Test
    @Transactional
    @Rollback(false)
    void deleteTestMethod(){

        //find an entity by id
        Long id = 5L;
        Product deleteProduct = productRepository.findById(id).get();

        //delete(entity)
        productRepository.delete(deleteProduct);
    }

    @Test
    @Transactional
    @Rollback(false)
    void deleteAllTestMethod(){

        productRepository.deleteAll();
    }

    @Test
    @Transactional
    @Rollback(false)
    void deleteSpecificTestMethod(){

        Product product = productRepository.findById(4l).get();

        Product product1 = productRepository.findById(5l).get();

        productRepository.deleteAll(List.of(product, product1));
    }











}
