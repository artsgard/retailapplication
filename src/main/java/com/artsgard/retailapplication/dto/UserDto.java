package com.artsgard.retailapplication.dto;

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
public class UserDto implements Serializable {
    private static final long serialVersionUID = -4757470046669926020L;

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private Timestamp registerDate;

    private Timestamp modifactionDate;

    private Boolean active;

    //private List<PurchaseDto> userPurchases; TODO

    private List<CompanyDto> userCompanies;

    private List<String> userCompanyRefList;

    private List<String> userPurchasesRefList;

}
