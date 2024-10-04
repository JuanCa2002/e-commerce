package com.test.e_commerce.services.clients.interfaces;

import com.test.e_commerce.models.domain.Category;
import com.test.e_commerce.models.exceptions.NotFoundException;
import com.test.e_commerce.models.exceptions.ServerException;

import java.util.List;

public interface CategoryClientService {

    Category getById(Integer id) throws NotFoundException, ServerException;

    List<Category> getAllCategories() throws ServerException;
}
