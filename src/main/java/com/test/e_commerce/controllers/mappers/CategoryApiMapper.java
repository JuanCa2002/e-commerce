package com.test.e_commerce.controllers.mappers;

import com.test.e_commerce.controllers.responses.CategoryResponse;
import com.test.e_commerce.models.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryApiMapper {

    CategoryResponse domainToResponse(Category domain);

    List<CategoryResponse> domainsToResponses(List<Category> responses);
}
