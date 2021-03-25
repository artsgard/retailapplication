package com.artsgard.retailapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.io.Serializable;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
public class PurchaseUpdateRequestDto implements Serializable {
    private static final long serialVersionUID = -9149434573783348587L;

    @ApiParam(value = "Purchase details")
    private String purchaseDetails;
/*
    @ApiParam(value = "Purchase reference")
    private String purchaseRef;
*/
    @ApiParam(value = "Purchase active")
    private Boolean active;

}