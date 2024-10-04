package com.test.e_commerce.models.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {

    private Integer pid;

    private String name;

    private Long priceFinal;

    private String description;

    private Integer categoryId;

    private List<String> images;
}
