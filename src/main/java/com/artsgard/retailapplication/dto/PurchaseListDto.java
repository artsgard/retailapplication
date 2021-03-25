package com.artsgard.retailapplication.dto;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
public class PurchaseListDto implements Serializable {
    private static final long serialVersionUID = 3707508471833506309L;

    private Integer id;

    private String purchaseDetails;

    private String orderRef;

    private Timestamp created;

    private Timestamp updated;

    private Boolean active;

    private Timestamp purchaseDate;

    private Pageable pageable;

}