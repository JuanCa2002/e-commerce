package com.test.e_commerce.services.core.interfaces;

import com.test.e_commerce.models.domain.Product;
import com.test.e_commerce.models.exceptions.BadRequestException;
import com.test.e_commerce.models.exceptions.NotFoundException;
import com.test.e_commerce.models.exceptions.ServerException;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product) throws NotFoundException, BadRequestException, ServerException;

    List<Product> getAllProducts() throws ServerException;
}
