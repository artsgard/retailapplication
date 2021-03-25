package com.artsgard.beerapplication.dto;

import lombok.Data;
import org.springframework.data.domain.Pageable;
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
public class UserListDto implements Serializable {
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

    //private List<PurchaseDto> userPurchases;

    private Pageable pageable;

}