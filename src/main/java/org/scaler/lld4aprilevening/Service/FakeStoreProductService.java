package org.scaler.lld4aprilevening.Service;

import org.scaler.lld4aprilevening.Models.Category;
import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.dtos.FakeStoreResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;


    @Autowired
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getProductById(long id) {
      FakeStoreResponseDto fdto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);

      if(fdto == null){
          return null;
      }

      // if response is there convert the response into product...
        return ConvertFakeStoreDtoToProduct(fdto);

    }

    public Product ConvertFakeStoreDtoToProduct(FakeStoreResponseDto fdto){

        Product p = new Product();
        p.setId(fdto.getId());
        p.setDesc(fdto.getDesc());
        p.setTitle(fdto.getTitle());
        p.setPrice(fdto.getPrice());
        p.setImage(fdto.getImage());

        Category c = new Category();
        c.setTitle(fdto.getCategory());

        p.setCategory(c);

        return p;

    }


    @Override
    public Product updateProduct(long id) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product p) {
        return null;
    }
}
