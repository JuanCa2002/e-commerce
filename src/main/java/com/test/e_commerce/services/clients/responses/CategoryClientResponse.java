package com.test.e_commerce.services.clients.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryClientResponse extends DateTimeClientResponse{

    private Integer id;

    private String name;

    private String image;
}
