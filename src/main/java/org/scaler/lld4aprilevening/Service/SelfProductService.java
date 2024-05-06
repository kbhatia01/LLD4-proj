package org.scaler.lld4aprilevening.Service;

import org.scaler.lld4aprilevening.Exceptions.ProductNotFound;
import org.scaler.lld4aprilevening.Models.Category;
import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.repo.CategoryRepo;
import org.scaler.lld4aprilevening.repo.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;


//@Primary
@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;
    SelfProductService(ProductRepo productRepo,
                       CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }
    @Override
    public Product getProductById(long id) throws ProductNotFound {

        Optional<Product> optionalProduct = productRepo.findById(id);

        if(optionalProduct.isEmpty()){
            throw  new ProductNotFound("Product npt found");
        }

        return optionalProduct.get();
    }

    @Override
    public Product updateProduct(long id, Product p) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product p) {

        // TODO: HANDLE EDGE CASES..
        // Before saving product we need to create category in db;

        Category category = p.getCategory();

        if(category.getId()==null){
            Category savedCategory = categoryRepo.save(category);
            p.setCategory(savedCategory);
        } else {
            // we need to check if id exists..
        }

        Product saveProduct = productRepo.save(p);

        Optional<Category> optionalCategory = categoryRepo.findById(category.getId());
        if(optionalCategory.isEmpty()){
            throw new RuntimeException("Category is empty,.,");
        }
        saveProduct.setCategory(optionalCategory.get());
        return saveProduct;
    }

    @Override
    public Product[] getAllProducts() {
        return new Product[0];
    }
}
