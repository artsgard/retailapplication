package com.artsgard.retailapplication.dto;

import com.artsgard.retailapplication.entity.ProductEntity;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;

/**
 *
 * @author WillemDragstra
 *
 */
@Data
public class ProductListDto implements Serializable {
    private static final long serialVersionUID = 253967753794162466L;

    private String name;

    private String productRef;

    private Boolean promotion;

    private String nationality;

    private String graduation;

    private ProductEntity.BeerType beerType;

    //private List<PurchaseDto> userPurchases;

    private Pageable pageable;

}