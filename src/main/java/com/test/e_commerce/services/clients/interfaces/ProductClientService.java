package com.test.e_commerce.services.clients.interfaces;

import com.test.e_commerce.models.domain.Product;
import com.test.e_commerce.models.exceptions.BadRequestException;
import com.test.e_commerce.models.exceptions.ServerException;

import java.util.List;

public interface ProductClientService {

    Product createProduct(Product product) throws BadRequestException, ServerException;

    List<Product> getAllProducts() throws ServerException;
}
