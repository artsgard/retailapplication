package com.artsgard.retailapplication.dto.request;

import com.artsgard.retailapplication.dto.ProductDto;
import com.artsgard.retailapplication.dto.PurchaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
@NoArgsConstructor
public class ProductPurchaseListRequestDto implements Serializable {
    private static final long serialVersionUID = -8774761818230369934L;

    private ProductDto productDto;
    private PurchaseDto purchaseDto;

    private String productPurchaseComment;
}