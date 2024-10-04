package com.test.e_commerce.services.clients.mappers;

import com.test.e_commerce.models.domain.Category;
import com.test.e_commerce.services.clients.responses.CategoryClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryClientMapper {

    @Mapping(target = "cid", source = "id")
    @Mapping(target = "title", source = "name")
    Category responseToDomain(CategoryClientResponse response);

    List<Category> responsesToDomain(List<CategoryClientResponse> responses);
}
