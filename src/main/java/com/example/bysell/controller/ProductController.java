package com.example.bysell.controller;

import com.example.bysell.models.Products;
import com.example.bysell.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String products(@PathVariable long id, Model model) {
        List<Products> collect = productService.listProducts().stream().filter(a -> a.getId() == id).collect(Collectors.toList());
        model.addAttribute("product", collect.get(0));
        return "product";
    }

}
