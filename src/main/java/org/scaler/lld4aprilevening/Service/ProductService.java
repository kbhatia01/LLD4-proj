package org.scaler.lld4aprilevening.Service;

import org.scaler.lld4aprilevening.Models.Product;

public interface ProductService {

  public  Product getProductById(long id);

    Product updateProduct(long id);
    Product deleteProduct(long id);
    Product createProduct(Product p);
}
