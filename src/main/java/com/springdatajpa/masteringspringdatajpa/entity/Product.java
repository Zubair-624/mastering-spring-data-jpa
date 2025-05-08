package com.springdatajpa.masteringspringdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "products", schema = "ecommerce")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_sku", nullable = false, unique = true)
    private String sku;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "product_price", nullable = false)
    private BigDecimal price;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "image_url")
    private String imageUrl;

    @CreationTimestamp
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

}
