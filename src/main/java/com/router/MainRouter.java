package com.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainRouter {

    @GetMapping("/")
    public String index(){
        return  "index";
    }
    @GetMapping("/product")
    public String product(){
        return "product";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
    @GetMapping("/blog/{id}")
    public String blog_details(){
        return "blog-detail";
    }
    @GetMapping("/product/{id}")
    public String product_details(){
        return "product-detail";
    }
    @GetMapping("/shopping-cart")
    public String shopping_cart(){
        return "shoping-cart";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
