package com.artsgard.retailapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class CompanyAssignRequestDto implements Serializable {
    private static final long serialVersionUID = 3492000992960418961L;

    @ApiParam(value = "Assign a list of companies to a user", required = true)
    private List<String> companyReferenceList;

}