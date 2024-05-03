package org.scaler.lld4aprilevening.Service;

import org.scaler.lld4aprilevening.Exceptions.ProductNotFound;
import org.scaler.lld4aprilevening.Models.Category;
import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.dtos.FakeStoreRequestDto;
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
    public Product getProductById(long id) throws ProductNotFound {
      FakeStoreResponseDto fdto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);


      if(fdto == null){
          throw new ProductNotFound();
      }

      // if response is there convert the response into product...
        return ConvertFakeStoreDtoToProduct(fdto);

    }

    public Product ConvertFakeStoreDtoToProduct(FakeStoreResponseDto fdto){

        Product p = new Product();
        p.setId(fdto.getId());
        p.setDescription(fdto.getDesc());
        p.setTitle(fdto.getTitle());
        p.setPrice(fdto.getPrice());
        p.setImage(fdto.getImage());

        Category c = new Category();
        c.setTitle(fdto.getCategory());

        p.setCategory(c);

        return p;

    }

    public FakeStoreRequestDto ConvertProductToFakeStoreRequest(Product p){
        FakeStoreRequestDto requestDto = new FakeStoreRequestDto();
        requestDto.setCategory(p.getCategory().getTitle());
        requestDto.setImage(p.getImage());
        requestDto.setPrice(p.getPrice());
        requestDto.setTitle(p.getTitle());
        requestDto.setDesc(p.getDescription());

        return requestDto;
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

        FakeStoreRequestDto fakeStoreRequestDto= ConvertProductToFakeStoreRequest(p);

        FakeStoreResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/products/",fakeStoreRequestDto, FakeStoreResponseDto.class);

        if (response == null){
            throw new RuntimeException("product is null");
        }
        return ConvertFakeStoreDtoToProduct(response);
    }

    public Product[] getAllProducts() {
       FakeStoreResponseDto[] fdto = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreResponseDto[].class);

         Product[] products = new Product[fdto.length];
            for(int i=0;i<fdto.length;i++){
                products[i] = ConvertFakeStoreDtoToProduct(fdto[i]);
            }
            return products;
    }


}
