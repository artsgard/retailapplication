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
public class ProductPurchaseAssignDto implements Serializable {
    private static final long serialVersionUID = -2276962569895752964L;

    @ApiParam(value = "Product purchase reference", required = true)
    private String purchaseRef;

    @ApiParam(value = "Product purchase comment")
    private String productPurchaseComment;

/*
    @ApiParam(value = "User name")
    private String username;
    TODO
*/
}