package com.test.e_commerce.services.clients.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductClientResponse extends DateTimeClientResponse{

    private Integer id;

    private String title;

    private Long price;

    private String description;

    private CategoryClientResponse category;

    private List<String> images;
}
