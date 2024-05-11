package org.scaler.lld4aprilevening.Controller;

import org.junit.jupiter.api.Test;
import org.scaler.lld4aprilevening.Exceptions.ProductNotFound;
import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;


    @MockBean
    private ProductService productService;

    @Test
    void TestGetProductById() throws ProductNotFound {

        Product p = new Product();

        when(productService.getProductById(1L)).thenReturn(p);

        ResponseEntity<Product> ExpectedResponseEntity = new ResponseEntity<>(p, HttpStatus.OK);

       ResponseEntity<Product> ActualResponse =  productController.getProductById(1L);

       assertEquals(ExpectedResponseEntity, ActualResponse);

    }


}