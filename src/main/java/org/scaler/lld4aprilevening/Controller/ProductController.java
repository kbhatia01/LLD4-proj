package org.scaler.lld4aprilevening.Controller;


import org.scaler.lld4aprilevening.Exceptions.ProductNotFound;
import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.Service.ProductService;
import org.scaler.lld4aprilevening.common.AuthCommon;
import org.scaler.lld4aprilevening.dtos.Roles;
import org.scaler.lld4aprilevening.dtos.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService ps;

    private AuthCommon authCommon;
    public ProductController(@Qualifier("SelfProductService") ProductService productService,
                             AuthCommon authCommon){
        this.ps = productService;
        this.authCommon = authCommon;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id, @RequestHeader("Auth") String auth) throws ProductNotFound {


            UserDto user = authCommon.validate(auth);

            if (user != null){
                for(Roles r : user.getRoles()){
                    if (r.getRole() == "ADMIN"){
                        Product p = ps.getProductById(id); // dependency..

                        return new ResponseEntity<>(p, HttpStatus.OK);
                    }
                }
            }

        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
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


    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return ps.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        return;
    }



}
