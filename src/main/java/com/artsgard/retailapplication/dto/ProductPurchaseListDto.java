package com.artsgard.retailapplication.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
@NoArgsConstructor
public class ProductPurchaseListDto implements Serializable {


    private ProductDto productDto;
    private UserDto userDto;

    private List<ProductDto> productDtoList;
    private List<UserDto> userDtoList;

    private Pageable pageable;
}
