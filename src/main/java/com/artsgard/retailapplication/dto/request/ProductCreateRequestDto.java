package com.artsgard.retailapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author WillemDragstra
 * @ApiModelProperty(hidden = true)
 */
@Data
public class ProductCreateRequestDto implements Serializable {
    private static final long serialVersionUID = 7746913721614479621L;

    @NotNull
    @Size(min = 2, max = 100)
    @ApiParam(value = "Product name", required = true)
    private String name;

    @NotNull
    @ApiParam(value = "Product reference", required = true)
    private String productRef;

    @ApiParam(value = "Product description", required = false)
    private String description;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=12, fraction=2)
    @ApiParam(value = "Product price", required = true)
    private BigDecimal price;

    @NotNull
    @ApiParam(value = "Product promotion", required = true)
    private Boolean promotion;

    @NotNull
    @ApiParam(value = "Bier graduation", required = true)
    private String graduation;

    @NotNull
    @ApiParam(value = "Bier type", required = true)
    private String beerType;

    @NotNull
    @ApiParam(value = "Product nationality", required = true)
    String nationality;

    @NotNull
    @ApiParam(value = "Company reference", required = false)
    private String CompanyRef;

}
