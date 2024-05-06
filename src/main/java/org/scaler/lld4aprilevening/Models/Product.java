package org.scaler.lld4aprilevening.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    private String image;
    @ManyToOne
    @JoinColumn
    private Category category;

}


/*
    1               1
    Product ---> Category ===> m:1
    M              1

 */
