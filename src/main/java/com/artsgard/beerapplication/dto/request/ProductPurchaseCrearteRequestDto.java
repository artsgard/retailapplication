package com.artsgard.beerapplication.dto.request;

import com.artsgard.beerapplication.dto.ProductDto;
import com.artsgard.beerapplication.dto.PurchaseDto;
import com.artsgard.beerapplication.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
@NoArgsConstructor
public class ProductPurchaseCrearteRequestDto implements Serializable {
    private static final long serialVersionUID = -7762722607349484342L;

    private ProductDto productDto;
    private PurchaseDto purchaseDto;

    private String productPurchaseComment;

}