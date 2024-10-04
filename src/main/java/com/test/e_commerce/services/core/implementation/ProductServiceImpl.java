package com.test.e_commerce.services.core.implementation;

import com.test.e_commerce.models.domain.Product;
import com.test.e_commerce.models.exceptions.BadRequestException;
import com.test.e_commerce.models.exceptions.NotFoundException;
import com.test.e_commerce.models.exceptions.ServerException;
import com.test.e_commerce.services.clients.interfaces.CategoryClientService;
import com.test.e_commerce.services.clients.interfaces.ProductClientService;
import com.test.e_commerce.services.core.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductClientService productClientService;

    private final CategoryClientService categoryClientService;

    @Override
    public Product createProduct(Product product) throws NotFoundException, BadRequestException, ServerException {
        categoryClientService.getById(product.getCategoryId());
        return productClientService.createProduct(product);
    }

    @Override
    public List<Product> getAllProducts() throws ServerException {
        return productClientService.getAllProducts();
    }
}
