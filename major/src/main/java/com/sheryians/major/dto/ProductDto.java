package com.sheryians.major.dto;

import com.sheryians.major.model.Category;
import lombok.Data;

import javax.persistence.Column;
@Data
public class ProductDto {


    private Long id;

    private String name;

    private Integer categoryId;

    private Double price;

    private Double weight;

    private String description;

    private  String imageName;

}
