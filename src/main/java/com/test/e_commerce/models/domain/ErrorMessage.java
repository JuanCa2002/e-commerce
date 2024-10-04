package com.test.e_commerce.models.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private Integer code;

    private String message;
}
