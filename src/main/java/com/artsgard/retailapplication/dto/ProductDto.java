package com.artsgard.retailapplication.dto;

import com.artsgard.retailapplication.entity.ProductEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author WillemDragstra
 *
 */
@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 7746913721614479621L;

    private Long id;

    private String name;

    private String productRef;

    private String description;

    private BigDecimal price;

    private Boolean promotion;

    private String graduation;

    private ProductEntity.BeerType beerType;

    private String nationality;

    private Timestamp creationDate;

    private List<PurchaseDto> userPurchases;

    private CompanyDto company;

    private List<String> productReferenceList;

}