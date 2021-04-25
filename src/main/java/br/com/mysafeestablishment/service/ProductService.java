package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.domain.Product;
import br.com.mysafeestablishment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product register(Product newProduct){
        productRepository.save(newProduct);
        return newProduct;
    }
}
