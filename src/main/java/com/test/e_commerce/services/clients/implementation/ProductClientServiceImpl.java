package com.test.e_commerce.services.clients.implementation;

import com.test.e_commerce.models.domain.Product;
import com.test.e_commerce.models.exceptions.BadRequestException;
import com.test.e_commerce.models.exceptions.ServerException;
import com.test.e_commerce.services.clients.apis.PlatzyApiClient;
import com.test.e_commerce.services.clients.interfaces.ProductClientService;
import com.test.e_commerce.services.clients.mappers.ProductClientMapper;
import com.test.e_commerce.services.clients.responses.ProductClientResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductClientServiceImpl implements ProductClientService {

    private final ProductClientMapper mapper;

    private final PlatzyApiClient client;

    @Override
    public Product createProduct(Product product) throws BadRequestException, ServerException{
        try{
            ResponseEntity<ProductClientResponse> response = client.createProduct(mapper.domainToRequest(product));
            return mapper.responseToDomain(response.getBody());
        }catch (FeignException.BadRequest ex){
            throw new BadRequestException(ex.getMessage());
        }catch (FeignException.InternalServerError ex){
            throw new ServerException();
        }
    }

    @Override
    public List<Product> getAllProducts() throws ServerException{
        try{
            ResponseEntity<List<ProductClientResponse>> response = client.getAllProducts();
            return mapper.responsesToDomains(response.getBody());
        }catch (FeignException.InternalServerError ex){
            throw new ServerException();
        }
    }
}
