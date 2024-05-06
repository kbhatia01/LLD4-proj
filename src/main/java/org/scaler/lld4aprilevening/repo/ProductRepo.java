package org.scaler.lld4aprilevening.repo;

import org.scaler.lld4aprilevening.Models.Product;
import org.scaler.lld4aprilevening.projection.ProductWithTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


    @Override
    Optional<Product> findById(Long id);

    Optional<Product> findByTitle(String title);

//    select * from Product where title="" and description=""
    List<Product> findByTitleAndDescription(String title, String Description);

    Product save(Product product);


    // HQL

    @Query("select p.title as title, p.description as description from  Product p where p.id=:id")
    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);


    // SQL

    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductWithTitleAndDescription someRandomQuery2(@Param("id") Long id);

}
