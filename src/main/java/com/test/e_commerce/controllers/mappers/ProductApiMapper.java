package com.test.e_commerce.controllers.mappers;

import com.test.e_commerce.controllers.requests.ProductRequest;
import com.test.e_commerce.controllers.responses.ProductCreateResponse;
import com.test.e_commerce.controllers.responses.ProductResponse;
import com.test.e_commerce.models.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductApiMapper {

    ProductResponse domainToResponse(Product domain);

    ProductCreateResponse domainToCreateResponse(Product domain);

    List<ProductResponse> domainsToResponses(List<Product> domains);

    @Mapping(target = "images", expression = "java(mapFirstImage(request.getImageUrl()))")
    Product requestToDomain(ProductRequest request);

    default List<String> mapFirstImage(String imageUrl) {
        List<String> images = new ArrayList<>();
        images.add(imageUrl);
        return images;
    }
}
