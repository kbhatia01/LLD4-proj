package org.scaler.lld4aprilevening.Exceptions;

public class ProductNotFound  extends Exception{
    public ProductNotFound(String productNptFound) {
        super(productNptFound);
    }
}
