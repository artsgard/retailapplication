package com.artsgard.retailapplication.dto;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class CompanyDto implements Serializable {
    private static final long serialVersionUID = -2817525798676309668L;

    private Long id;
    private String companyName;
    private String companyRef;
    private String description;
    private Timestamp registerDate;

    private List<ProductDto> compànyProducts = new ArrayList<>(0);

    private List<String> productReferenceList;

    private List<String> companyReferenceList;

}

