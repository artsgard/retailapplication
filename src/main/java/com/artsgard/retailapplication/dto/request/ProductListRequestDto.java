package com.artsgard.retailapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.io.Serializable;

/**
 *
 * @author WillemDragstra
 *
 */
@Data
public class ProductListRequestDto implements Serializable {
    private static final long serialVersionUID = -217442041621601244L;

    @ApiParam(value = "Product name")
    private String name;

    @ApiParam(value = "Product reference")
    private String productRef;

    @ApiParam(value = "Product nationality")
    private String nationality;

    @ApiParam(value = "Product graduation")
    private String graduation;

    @ApiParam(value = "Product beer type")
    private String beerType;

    @ApiParam(value = "Product promotion")
    private Boolean promotion;

}