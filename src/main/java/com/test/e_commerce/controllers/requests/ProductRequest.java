package com.test.e_commerce.controllers.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    @NotNull
    @NotEmpty
    @NotBlank
    @Schema(description = "Product name")
    private String name;

    @NotNull
    @Min(value = 0)
    @Schema(description = "Product price")
    private Long priceFinal;

    @NotNull
    @NotEmpty
    @NotBlank
    @Schema(description = "Product description")
    private String description;

    @NotNull
    @Min(value = 0)
    @Schema(description = "Product category")
    private Integer categoryId;

    @NotNull
    @NotEmpty
    @NotBlank
    @Schema(description = "Product image")
    @Pattern(regexp = "^(http|https)://.*$", message = " has an invalid image URL format")
    private String imageUrl;
}
