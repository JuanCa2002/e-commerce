package com.test.e_commerce.services.clients.implementation;

import com.test.e_commerce.models.domain.Category;
import com.test.e_commerce.models.exceptions.NotFoundException;
import com.test.e_commerce.models.exceptions.ServerException;
import com.test.e_commerce.models.exceptions.category.CategoryNotFoundException;
import com.test.e_commerce.services.clients.apis.PlatzyApiClient;
import com.test.e_commerce.services.clients.interfaces.CategoryClientService;
import com.test.e_commerce.services.clients.mappers.CategoryClientMapper;
import com.test.e_commerce.services.clients.responses.CategoryClientResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryClientServiceImpl implements CategoryClientService {

    private final PlatzyApiClient client;

    private final CategoryClientMapper mapper;

    @Override
    public Category getById(Integer id) throws NotFoundException, ServerException {
        try{
            ResponseEntity<CategoryClientResponse> response = client.getCategoryById(id);
            return mapper.responseToDomain(response.getBody());
        }catch (FeignException.BadRequest ex){
            throw new CategoryNotFoundException("Category not found with ID: " + id);
        }catch (FeignException.InternalServerError ex){
            throw new ServerException();
        }
    }

    @Override
    public List<Category> getAllCategories() throws ServerException {
        try{
            ResponseEntity<List<CategoryClientResponse>> response = client.getAllCategories();
            return mapper.responsesToDomain(response.getBody());
        }catch (FeignException.InternalServerError ex){
            throw new ServerException();
        }
    }
}
