package com.pharmacy.farmAd.controllers;

import com.pharmacy.farmAd.products.Product;
import com.pharmacy.farmAd.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public String homePage(Model page){
        page.addAttribute("username", "Adara");
        page.addAttribute("color", "red");
        return "/home";
    }

   @GetMapping("/products")
    public String viewProducts(Model model){
       List<Product> products = productService.findAll();
       model.addAttribute("products", products);
       return "products.html";
   }

    @PostMapping("/products")
    public String addProduct(Product p, Model model){
        productService.addProduct(p);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
