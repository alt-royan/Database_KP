package com.example.databasekp.controller;

import com.example.databasekp.model.Product;
import com.example.databasekp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public String clients(Model model) {
        var products = productService.getAll();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/product")
    public String saveOrder(@RequestParam String title,
                            @RequestParam Integer amount,
                            @RequestParam String price,
                            @RequestParam String description,
                            @RequestParam String id) {
        var product = new Product();
        product.setId(Long.parseLong(id));
        product.setAmount(amount);
        product.setTitle(title);
        product.setPrice(Double.parseDouble(price));
        product.setDescription(description);
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/{id}")
    public String getClient(@PathVariable Long id, Model model) {
        var product = productService.getById(id);
        var partitions = productService.getAllPartitions();
        model.addAttribute("product", product);
        model.addAttribute("partitions", partitions);
        return "productPage";
    }
}