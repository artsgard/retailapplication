package com.artsgard.beerapplication.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author WillemDragstra
 * 
 * 
 */
@Data
public class PurchaseDto implements Serializable {
    private static final long serialVersionUID = 3707508471833506309L;

    private Long id;

    private String purchaseDetails;

    private String purchaseRef;

    private Timestamp created;

    private Timestamp updated;

    private Timestamp purchaseDate;

    private Boolean active;

    private UserDto userDto;

    private List<String> productPurchaseReferenseList;
    
}
