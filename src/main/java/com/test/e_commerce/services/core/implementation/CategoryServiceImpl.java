package com.test.e_commerce.services.core.implementation;

import com.test.e_commerce.models.domain.Category;
import com.test.e_commerce.models.exceptions.ServerException;
import com.test.e_commerce.services.clients.interfaces.CategoryClientService;
import com.test.e_commerce.services.core.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryClientService categoryClientService;

    @Override
    public List<Category> getAllCategories() throws ServerException {
        return categoryClientService.getAllCategories();
    }
}
