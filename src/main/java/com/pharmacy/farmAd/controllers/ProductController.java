package com.pharmacy.farmAd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/home")
    public String homePage(Model page){
        page.addAttribute("username", "Adara");
        page.addAttribute("color", "red");
        return "/home";
    }
}
