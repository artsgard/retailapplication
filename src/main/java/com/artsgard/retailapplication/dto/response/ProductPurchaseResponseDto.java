package com.artsgard.retailapplication.dto.response;

import com.artsgard.retailapplication.dto.ProductDto;
import com.artsgard.retailapplication.dto.PurchaseDto;
import com.artsgard.retailapplication.dto.UserDto;
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
public class ProductPurchaseResponseDto implements Serializable {
    private static final long serialVersionUID = 3535515292538510544L;

    private ProductDto productDto;
    private UserDto userDto;

    private Timestamp productPurchaseDate;
    private String productPurchaseComment;

    private List<ProductDto> productDtoList;
    private List<PurchaseDto> purchaseDtoList;
}
