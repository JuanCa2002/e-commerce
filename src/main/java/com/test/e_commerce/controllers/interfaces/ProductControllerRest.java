package com.test.e_commerce.controllers.interfaces;

import com.test.e_commerce.controllers.requests.ProductRequest;
import com.test.e_commerce.controllers.responses.ProductCreateResponse;
import com.test.e_commerce.controllers.responses.ProductResponse;
import com.test.e_commerce.models.domain.ErrorMessage;
import com.test.e_commerce.models.exceptions.BadRequestException;
import com.test.e_commerce.models.exceptions.NotFoundException;
import com.test.e_commerce.models.exceptions.ServerException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Product", description = "Services about products")
public interface ProductControllerRest {

    @Operation(summary = "Create new product", description = "Add a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New product added successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductCreateResponse.class))),
            @ApiResponse(responseCode = "400", description = "In case of bad request error", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "404", description = "In case of not found error", content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "500", description = "In case of internal server error", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductRequest request) throws NotFoundException, BadRequestException, ServerException;

    @Operation(summary = "Get all products", description = "List of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of products", content = @Content(mediaType = "application/json", array= @ArraySchema(schema = @Schema(implementation = ProductResponse.class)))),
            @ApiResponse(responseCode = "500", description = "In case of internal server error", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))})
    ResponseEntity<List<ProductResponse>> getAllProducts() throws ServerException;
}
