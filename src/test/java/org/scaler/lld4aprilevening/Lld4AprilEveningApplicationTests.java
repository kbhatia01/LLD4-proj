package org.scaler.lld4aprilevening;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.scaler.lld4aprilevening.Controller.ProductController;
import org.scaler.lld4aprilevening.Models.Category;
import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.projection.ProductWithTitleAndDescription;
import org.scaler.lld4aprilevening.repo.CategoryRepo;
import org.scaler.lld4aprilevening.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

//@SpringBootTest // context of sprintboot application
class Lld4AprilEveningApplicationTests {

    @Test
    void contextLoads() {
    }


}
