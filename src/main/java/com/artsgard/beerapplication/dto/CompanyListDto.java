package com.artsgard.beerapplication.dto;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;

@Data
public class CompanyListDto implements Serializable {
    private static final long serialVersionUID = -1426912246211303428L;

    private String companyName;
    private String companyRef;

    private Pageable pageable;

}
