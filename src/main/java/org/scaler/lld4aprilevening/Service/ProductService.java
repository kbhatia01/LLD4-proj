package org.scaler.lld4aprilevening.Service;

import org.scaler.lld4aprilevening.Exceptions.ProductNotFound;
import org.scaler.lld4aprilevening.Models.Product;

public interface ProductService {

  public  Product getProductById(long id) throws ProductNotFound;

    Product updateProduct(long id);
    Product deleteProduct(long id);
    Product createProduct(Product p);

    Product[] getAllProducts();
}
