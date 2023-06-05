package com.recycling.gogreen.repository;

import com.recycling.gogreen.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
