package com.artsgard.beerapplication.dto;

import com.artsgard.beerapplication.entity.ProductEntity;
import io.swagger.annotations.ApiParam;
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