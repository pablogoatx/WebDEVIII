package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByResourceId(UUID resourceId);

    default List<Product> getAll() {
        return findAll();
    }

    default Product updateProduct(Product product) {
        return save(product);
    }

    default Product getByResourceId(UUID resourceId) {
        return this.findByResourceId(resourceId).orElse(null);
    }
}
