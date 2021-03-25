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
public class ProductPurchaseUpdateRequestDto implements Serializable {
    private static final long serialVersionUID = -1974736615926802488L;

    private ProductDto productDto;
    private PurchaseDto purchaseDto;

    private String productPurchaseComment;
}