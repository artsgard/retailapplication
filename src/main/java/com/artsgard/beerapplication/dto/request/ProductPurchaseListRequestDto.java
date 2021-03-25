package com.artsgard.beerapplication.dto.request;

import com.artsgard.beerapplication.dto.ProductDto;
import com.artsgard.beerapplication.dto.PurchaseDto;
import com.artsgard.beerapplication.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

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