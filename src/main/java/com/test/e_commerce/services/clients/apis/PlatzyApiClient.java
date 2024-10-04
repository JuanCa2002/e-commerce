package com.test.e_commerce.services.clients.apis;

import com.test.e_commerce.services.clients.requests.ProductClientRequest;
import com.test.e_commerce.services.clients.responses.CategoryClientResponse;
import com.test.e_commerce.services.clients.responses.ProductClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(name = "platzy-client", url = "${url.platzy-client}")
public interface PlatzyApiClient {

    @GetMapping("/products")
    ResponseEntity<List<ProductClientResponse>> getAllProducts();

    @PostMapping("/products")
    ResponseEntity<ProductClientResponse> createProduct(@RequestBody ProductClientRequest request);

    @GetMapping("/categories")
    ResponseEntity<List<CategoryClientResponse>> getAllCategories();

    @GetMapping("/categories/{id}")
    ResponseEntity<CategoryClientResponse> getCategoryById(@PathVariable Integer id);

}
