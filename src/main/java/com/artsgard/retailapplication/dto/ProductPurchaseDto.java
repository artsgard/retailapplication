package com.artsgard.retailapplication.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
@NoArgsConstructor
public class ProductPurchaseDto implements Serializable {

    private ProductDto productDto;

    private PurchaseDto purchaseDto;

    private Timestamp productPurchaseDate;

    private String productPurchaseComment;

    private String username;

}
