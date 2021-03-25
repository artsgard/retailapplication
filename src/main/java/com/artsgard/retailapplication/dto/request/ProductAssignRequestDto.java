package com.artsgard.retailapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class ProductAssignRequestDto implements Serializable {
    private static final long serialVersionUID = -7759152149357560865L;

    @ApiParam(value = "Assign a list of products to a company", required = true)
    private List<String> productReferenceList;

}