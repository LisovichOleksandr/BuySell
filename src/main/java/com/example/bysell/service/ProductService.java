package com.example.bysell.service;

import com.example.bysell.models.Products;

import java.util.List;

public interface ProductService {
    List<Products> listProducts();
    void save(Products products);
    void deleteProduct(Long id);
}
