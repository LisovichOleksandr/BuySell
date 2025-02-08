package com.example.bysell.service;

import com.example.bysell.models.Image;
import com.example.bysell.models.Product;
import com.example.bysell.repository.ProductRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listProducts(String title) {
        System.out.println(title);
        log.info("title = {}", title);
        List<Product> all = productRepository.findAll();
        if (title != null)
            return productRepository.findByTitle(title + "%");
        return all;
    }


    @Override
    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if(file1.getSize() != 0){
            image1 = this.toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if(file2.getSize() != 0){
            image2 = this.toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if(file3.getSize() != 0){
            image3 = this.toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        log.info("Saving new Product, Title: {}; Author: {}", product.getTitle(), product.getAuthor());
        Product productFromDB = this.productRepository.save(product);
        productFromDB.setPreviewImageId(productFromDB.getImages().get(0).getId());
        this.productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setBytes(file.getBytes());
        image.setSize(file.getSize());
        return image;
    }

    @Override
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> byId = this.productRepository.findById(id);
        return byId.orElseThrow();
    }

}
