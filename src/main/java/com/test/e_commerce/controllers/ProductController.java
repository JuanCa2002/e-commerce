package com.test.e_commerce.controllers;

import com.test.e_commerce.controllers.interfaces.ProductControllerRest;
import com.test.e_commerce.controllers.mappers.ProductApiMapper;
import com.test.e_commerce.controllers.requests.ProductRequest;
import com.test.e_commerce.controllers.responses.ProductCreateResponse;
import com.test.e_commerce.controllers.responses.ProductResponse;
import com.test.e_commerce.models.exceptions.BadRequestException;
import com.test.e_commerce.models.exceptions.NotFoundException;
import com.test.e_commerce.models.exceptions.ServerException;
import com.test.e_commerce.services.core.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("${request-mapping.controller.products}")
public class ProductController implements ProductControllerRest {

    private final ProductService service;

    private final ProductApiMapper apiMapper;

    @PostMapping
    @Override
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductRequest request) throws NotFoundException, BadRequestException, ServerException {
        var response = service.createProduct(apiMapper.requestToDomain(request));
        return new ResponseEntity<>(apiMapper.domainToCreateResponse(response), HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts() throws ServerException {
        var response = service.getAllProducts();
        return new ResponseEntity<>(apiMapper.domainsToResponses(response), HttpStatus.OK);
    }
}
