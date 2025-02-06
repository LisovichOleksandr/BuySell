package com.example.bysell.service;

import com.example.bysell.models.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Products> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Products(++ID, "Car", "best car", "New York", "Alex", 22000000));
        products.add(new Products(++ID, "Bike", "best of the best BIKE", "New York", "Alex", 23000000));

    }

    public ProductServiceImpl() {
    }

    @Override
    public List<Products> listProducts() {
        return this.products;
    }

    @Override
    public void save(Products products) {
        products.setId(++ID);
        this.products.add(products);
    }

    @Override
    public void deleteProduct(Long id) {
        this.products.removeIf(p -> p.getId().equals(id));
    }

}
