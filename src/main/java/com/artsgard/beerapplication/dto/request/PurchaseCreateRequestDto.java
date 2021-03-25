package com.artsgard.beerapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
public class PurchaseCreateRequestDto implements Serializable {
    private static final long serialVersionUID = 3707508471833506309L;
/*
    @NotEmpty
    @NotNull
    @ApiParam(value = "Purchase reference", required = true)
    private String purchaseRef;
*/

    @ApiParam(value = "Purchase Details", required = false)
    private String purchaseDetails;

    @NotNull
    @Size(min = 2, max = 20)
    @ApiParam(value = "User name of the purchase", required = true)
    private String username;

}