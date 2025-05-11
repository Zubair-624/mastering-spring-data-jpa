package com.springdatajpa.masteringspringdatajpa.repository;

import com.springdatajpa.masteringspringdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
//import static org.junit.jupiter.api.Assertions.assertNotNull;



import java.math.BigDecimal;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void saveTestMethod(){

        //create product object
        Product product = Product.builder()
                .name("Iphone 6")
                .description("This is an Iphone 6 product")
                .sku("ip152")
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





}
