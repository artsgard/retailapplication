package com.artsgard.retailapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 *
 * @author WillemDragstra
 *
 */
@Data
public class ProductUpdateRequestDto implements Serializable {
    private static final long serialVersionUID = -5472854311990964444L;

    @ApiParam(value = "Product name")
    private String name;

    @ApiParam(value = "Product reference")
    private String productRef;

    @ApiParam(value = "Product description")
    private String description;

    @ApiParam(value = "Product price")
    private BigDecimal price;

    @ApiParam(value = "Company reference")
    private String companyRef;

    @ApiParam(value = "Product promotion")
    private Boolean promotion;

    @ApiParam(value = "Bier graduation")
    private String graduation;

    @ApiParam(value = "Bier type")
    private String beerType;

    @ApiParam(value = "Product nationality")
    String nationality;


}