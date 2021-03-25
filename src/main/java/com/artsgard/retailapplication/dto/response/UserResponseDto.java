package com.artsgard.retailapplication.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
public class UserResponseDto implements Serializable {
    private static final long serialVersionUID = 3319572751919709737L;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private Timestamp registerDate;

    private Timestamp modifactionDate;

    private Boolean active;

    private List<String> userCompanyRefList;

    private List<String> userPurchasesRefList;

    //private List<PurchaseDto> userPurchases;

}