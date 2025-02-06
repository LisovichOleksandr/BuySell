package com.example.bysell.controller;

import com.example.bysell.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", productService.listProducts());
        return "products";
    }
}
