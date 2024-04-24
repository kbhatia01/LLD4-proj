package org.scaler.lld4aprilevening.Controller;


import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService ps;
    public ProductController(ProductService productService){
        this.ps = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return ps.getProductById(id);
    }


    @GetMapping("/")
    public List<Product> getAllProducts(){
        return null;
        // TODO: HW..
    }
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }


    @PutMapping("/")
    public Product updateProduct(@RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        return;
    }



}
