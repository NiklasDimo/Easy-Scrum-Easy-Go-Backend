package com.example.ESEG.repository;

import com.example.ESEG.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}

