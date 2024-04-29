package org.scaler.lld4aprilevening.Controller;


import org.scaler.lld4aprilevening.Exceptions.ProductNotFound;
import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFound {


            return new ResponseEntity<>(ps.getProductById(id), HttpStatus.OK);
//try{
//        } catch (ArithmeticException ae){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        } catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
    }


    @GetMapping("/")
    public List<Product> getAllProducts(){
      return List.of(ps.getAllProducts());
    }
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        // validation here...
        return ps.createProduct(product);
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
