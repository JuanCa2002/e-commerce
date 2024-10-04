package com.test.e_commerce.services.clients.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductClientRequest {

    private String title;

    private Long price;

    private String description;

    private Integer categoryId;

    private List<String> images;

}
