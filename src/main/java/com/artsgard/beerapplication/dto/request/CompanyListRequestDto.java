package com.artsgard.beerapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.io.Serializable;

@Data
public class CompanyListRequestDto implements Serializable {
    private static final long serialVersionUID = 3492000992960418961L;

    @ApiParam(value = "Company name")
    private String companyName;

    @ApiParam(value = "Company reference")
    private String companyRef;

}