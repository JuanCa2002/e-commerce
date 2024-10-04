package com.test.e_commerce.services.clients.mappers;

import com.test.e_commerce.models.domain.Product;
import com.test.e_commerce.services.clients.requests.ProductClientRequest;
import com.test.e_commerce.services.clients.responses.ProductClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductClientMapper {

    @Mapping(target = "pid", source = "id")
    @Mapping(target = "name", source = "title")
    @Mapping(target = "priceFinal", source = "price")
    Product responseToDomain(ProductClientResponse response);

    List<Product> responsesToDomains(List<ProductClientResponse> responses);

    @Mapping(target = "title", source = "name")
    @Mapping(target = "price", source = "priceFinal")
    ProductClientRequest domainToRequest(Product domain);
}
