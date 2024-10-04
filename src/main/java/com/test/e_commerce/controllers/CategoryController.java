package com.test.e_commerce.controllers;

import com.test.e_commerce.controllers.interfaces.CategoryControllerRest;
import com.test.e_commerce.controllers.mappers.CategoryApiMapper;
import com.test.e_commerce.controllers.responses.CategoryResponse;
import com.test.e_commerce.models.exceptions.ServerException;
import com.test.e_commerce.services.core.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${request-mapping.controller.categories}")
public class CategoryController implements CategoryControllerRest {

    private final CategoryService service;

    private final CategoryApiMapper apiMapper;

    @GetMapping
    @Override
    public ResponseEntity<List<CategoryResponse>> getAllCategories() throws ServerException {
        var response = service.getAllCategories();
        return new ResponseEntity<>(apiMapper.domainsToResponses(response), HttpStatus.OK);
    }
}
