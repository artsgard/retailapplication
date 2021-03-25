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
public class PurchaseListRequestDto implements Serializable {
    private static final long serialVersionUID = 5730542288280949060L;

    @ApiParam(value = "Purchase reference")
    private String purchaseRef;

    @ApiParam(value = "Purchase active")
    private Boolean active;

    @ApiParam(value = "Purchase details")
    private String purchaseDetails;

}