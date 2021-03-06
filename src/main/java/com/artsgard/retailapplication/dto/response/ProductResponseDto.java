package com.artsgard.retailapplication.dto.response;

import com.artsgard.retailapplication.entity.ProductEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author WillemDragstra
 *
 */
@Data
public class ProductResponseDto implements Serializable {
    private static final long serialVersionUID = 4273052538336478355L;

    private String productRef;

    private String name;

    private String description;

    private BigDecimal price;

    private Boolean promotion;

    private String graduation;

    private ProductEntity.BeerType beerType;

    String nationality;

    private Timestamp creationDate;

    private String companyRef;

    //private List<PurchaseDto> userPurchases;

}