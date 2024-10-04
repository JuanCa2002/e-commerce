package com.test.e_commerce.models.exceptions.category;

import com.test.e_commerce.models.exceptions.NotFoundException;

public class CategoryNotFoundException extends NotFoundException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
