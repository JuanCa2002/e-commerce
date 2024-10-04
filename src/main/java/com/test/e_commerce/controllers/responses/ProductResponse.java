package com.test.e_commerce.controllers.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private Integer pid;

    private String name;

    private Long priceFinal;

    private String description;
}
