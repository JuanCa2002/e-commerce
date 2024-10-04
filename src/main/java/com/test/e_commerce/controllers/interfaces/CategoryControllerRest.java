package com.test.e_commerce.controllers.interfaces;

import com.test.e_commerce.controllers.responses.CategoryResponse;
import com.test.e_commerce.models.domain.ErrorMessage;
import com.test.e_commerce.models.exceptions.ServerException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Category", description = "Services about categories")
public interface CategoryControllerRest {

    @Operation(summary = "Get all categories", description = "List of all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of categories", content = @Content(mediaType = "application/json", array= @ArraySchema(schema = @Schema(implementation = CategoryResponse.class)))),
            @ApiResponse(responseCode = "500", description = "In case of internal server error", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<List<CategoryResponse>> getAllCategories() throws ServerException;
}
