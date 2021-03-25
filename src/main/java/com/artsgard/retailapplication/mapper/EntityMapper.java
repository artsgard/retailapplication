package com.artsgard.retailapplication.mapper;

import com.artsgard.retailapplication.dto.*;
import com.artsgard.retailapplication.dto.request.ProductCreateRequestDto;
import com.artsgard.retailapplication.dto.request.UserCreateRequestDto;
import com.artsgard.retailapplication.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 *
 * @author WillemDragstra
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface EntityMapper extends BaseMapper {

    ProductEntity productDtoToProductEntity(ProductDto source);

    ProductEntity productRequestDtoToProductEntity(ProductCreateRequestDto source);

    ProductEntity productListDtoToProductEntity(ProductListDto source);

    UserEntity userDtoToUserEntity(UserDto source);

    UserEntity userDtoToUserCreateRequestDto(UserCreateRequestDto source);

    UserEntity userListDtoToUserEntity(UserListDto source);

    @Mapping(source = "userDto", target = "user")
    PurchaseEntity purchaseDtoToPurchaseEntity(PurchaseDto source);

    PurchaseEntity purchaseListDtoToPurchaseEntity(PurchaseListDto source);

    CompanyEntity companyDtoToCompanyEntity(CompanyDto source);

    CompanyEntity companyListDtoToCompanyEntity(CompanyListDto source);

    List<ProductEntity> productDtoListToProductEntityList(List<ProductDto> source);

    @Mapping(source = "purchaseDto", target = "purchase")
    @Mapping(source = "productDto", target = "product")
    ProductPurchaseEntity productPurchaseDtoToProductPurchaseEntity(ProductPurchaseDto source);

    default ProductPurchaseEntityId buildProductPurchaseEntityId(ProductPurchaseDto dto) {
        return new ProductPurchaseEntityId(dto.getProductDto().getId(), dto.getPurchaseDto().getId());
    }

}
