package com.test.e_commerce.services.core.interfaces;

import com.test.e_commerce.models.domain.Category;
import com.test.e_commerce.models.exceptions.ServerException;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories() throws ServerException;
}
