package com.example.bysell.controller;

import com.example.bysell.models.Product;
import com.example.bysell.repository.ImageRepository;
import com.example.bysell.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String productInfo(@PathVariable long id, Model model) {
        Product productById = productService.getProductById(id);
        model.addAttribute("product", productById);
        model.addAttribute("images", productById.getImages());
        return "product";
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam(name = "file1")MultipartFile file1,
                                @RequestParam(name = "file2")MultipartFile file2,
                                @RequestParam(name = "file3")MultipartFile file3,
                                Product product) throws IOException {
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
