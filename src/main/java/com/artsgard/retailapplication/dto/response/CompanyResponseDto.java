package com.artsgard.retailapplication.dto.response;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class CompanyResponseDto implements Serializable {
    private static final long serialVersionUID = 6808870675812383233L;

    private Long id;
    private String companyName;
    private String companyRef;
    private String description;
    private Timestamp registerDate;

    //private List<ProductDto> compànyProducts = new ArrayList<>(0);
    private List<String> productReferenceList;

}
