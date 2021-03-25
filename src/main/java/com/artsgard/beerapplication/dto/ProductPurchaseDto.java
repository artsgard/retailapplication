package com.artsgard.beerapplication.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

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
