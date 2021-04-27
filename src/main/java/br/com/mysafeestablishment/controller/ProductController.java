package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.domain.Product;
import br.com.mysafeestablishment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product/register")
    public Product registerProduct(@RequestBody Product product){
        return productService.register(product);
    }

}
