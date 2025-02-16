package com.example.bysell.service;

import com.example.bysell.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> listProducts(String title);
    void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;
    void deleteProduct(Long id);
    Product getProductById(long id);
}
