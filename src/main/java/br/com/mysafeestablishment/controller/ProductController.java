package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.client.MySafeEstablishmentClient;
import br.com.mysafeestablishment.api.domain.Product;
import br.com.mysafeestablishment.api.response.MessageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/private")
@CrossOrigin
public class ProductController {

    private final MySafeEstablishmentClient api;

    public ProductController() {
        this.api = new MySafeEstablishmentClient();
    }

    @GetMapping("/product/{id}")
    public Product productById(@PathVariable() Long id) throws Exception {
        return api.productById(id);
    }

    @GetMapping("/products")
    public ArrayList<Product> allProducts() throws Exception {
        return api.allProducts();
    }

    @PostMapping("/product/register")
    public Product registerProduct(@RequestBody Product product) throws Exception {
        return api.registerProduct(product);
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) throws Exception {
        return api.updateProduct(product);
    }

    @DeleteMapping("product/delete/{id}")
    public MessageResponse deleteProduct(@PathVariable() Long id) throws Exception {
        return api.delectProduct(id);
    }
}
