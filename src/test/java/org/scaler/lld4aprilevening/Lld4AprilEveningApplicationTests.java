package org.scaler.lld4aprilevening;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.scaler.lld4aprilevening.Models.Category;
import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.projection.ProductWithTitleAndDescription;
import org.scaler.lld4aprilevening.repo.CategoryRepo;
import org.scaler.lld4aprilevening.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Lld4AprilEveningApplicationTests {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    public void testTC(){
        Optional<Category> optionalCategory = categoryRepo.findById(1L);

        Category category = optionalCategory.get();

        List<Product> products = category.getProducts();

        System.out.println("Testing eager loading..");


        ProductWithTitleAndDescription p = productRepo.someRandomQuery(1L);

        System.out.println(p.getTitle());
        System.out.println(p.getDescription());

        ProductWithTitleAndDescription p2 = productRepo.someRandomQuery2(1L);
        System.out.println(p2.getTitle());
        System.out.println(p2.getDescription());
    }

}
