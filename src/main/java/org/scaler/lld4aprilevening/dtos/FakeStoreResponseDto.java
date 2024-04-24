package org.scaler.lld4aprilevening.dtos;

import lombok.Data;
import org.scaler.lld4aprilevening.Models.Category;

@Data
public class FakeStoreResponseDto {

    public Long id;
    private String title;
    private double price;
    private String desc;
    private String image;
    private String category;
}
