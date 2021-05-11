package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.domain.Product;
import br.com.mysafeestablishment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/private/products")
    public ArrayList<Product> allProducts(){
        return productService.allProducts();
    }

    @PostMapping("/private/owner/product/register")
    public ResponseEntity<String> registerProduct(@RequestBody Product product){
        return productService.register(product);
    }

    @DeleteMapping("/private/owner/product/delete")
    public ResponseEntity<String> delectProduct(@RequestBody Product product){
        return productService.delete(product);
    }

    @PutMapping("/private/owner/product/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        return productService.update(product);
    }


}
