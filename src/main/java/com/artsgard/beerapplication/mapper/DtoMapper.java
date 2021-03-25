package com.artsgard.beerapplication.mapper;

import com.artsgard.beerapplication.dto.*;
import com.artsgard.beerapplication.dto.request.*;
import com.artsgard.beerapplication.dto.response.CompanyResponseDto;
import com.artsgard.beerapplication.dto.response.PurchaseResponseDto;
import com.artsgard.beerapplication.dto.response.ProductResponseDto;
import com.artsgard.beerapplication.dto.response.UserResponseDto;
import com.artsgard.beerapplication.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WillemDragstra
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface DtoMapper extends BaseMapper {

    ProductListDto productListRequestDtoToProductListDto(ProductListRequestDto source);

    PurchaseListDto purchaseListRequestDtoToPurchaseListDto(PurchaseListRequestDto source);

    UserListDto userListRequestDtoToUserListDto(UserListRequestDto source);

    @Mapping(source = "userCompanies", target = "userCompanyRefList", qualifiedByName = "buildUserCompanyReferenseList")
    @Mapping(source = "userPurchases", target = "userPurchasesRefList", qualifiedByName = "buildUserPurchasesReferenseList")
    UserDto userEntityToUserDto(UserEntity source);

    @Named("buildUserCompanyReferenseList")
    default List<String> buildUserCompanyReferenseList(List<CompanyEntity> list) {
        if (list == null) {
            return null;
        }

        List<String> list1 = new ArrayList(list.size());
        list.forEach((companyEntity) -> {
            list1.add(companyEntity.getCompanyRef());
        });
        return list1;
    }

    @Named("buildUserPurchasesReferenseList")
    default List<String> buildUserPurchasesReferenseList(List<PurchaseEntity> list) {
        if (list == null) {
            return null;
        }

        List<String> list1 = new ArrayList(list.size());
        list.forEach((purchaseEntity) -> {
            list1.add(purchaseEntity.getPurchaseRef());
        });
        return list1;
    }

    ProductDto productEntityToProductDto(ProductEntity source);

    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "productPurchases", target = "productPurchaseReferenseList", qualifiedByName = "buildProductPurchaseReferenseList")
    PurchaseDto purchaseEntityToPurchaseDto(PurchaseEntity source);

    @Named("buildProductPurchaseReferenseList")
    default List<String> buildProductPurchaseReferenseList(List<ProductPurchaseEntity> list) {
        if (list == null) {
            return null;
        }

        List<String> list1 = new ArrayList(list.size());
        list.forEach((productPurchaseEntity) -> {
            list1.add(productPurchaseEntity.getProduct().getProductRef());
        });
        return list1;
    }

    @Mapping(source = "companyRef", target = "company.companyRef")
    @Mapping(source = "beerType", target = "beerType")
    ProductDto productCreateRequestDtoToProductDto(ProductCreateRequestDto source);

    @Mapping(source = "beerType", target = "beerType")
    @Mapping(source = "companyRef", target = "company.companyRef")
    ProductDto productUpdateRequestDtoToProductDto(ProductUpdateRequestDto source);

    UserDto userCreateRequestDtoToUserDto(UserCreateRequestDto source);

    UserDto userUpdateRequestDtoToUserDto(UserUpdateRequestDto source);

    PurchaseDto purchaseCreateRequestDtoToPurchaseDto(PurchaseCreateRequestDto source);

    PurchaseDto purchaseUpdateRequestDtoToPurchaseDto(PurchaseUpdateRequestDto source);

    @Mapping(source = "company.companyRef", target = "companyRef")
    ProductResponseDto productDtoToProductResponseDto(ProductDto source);

    @Mapping(source = "userDto.username", target = "username")
    PurchaseResponseDto purchaseDtoToPurchaseResponseDto(PurchaseDto source);

    UserResponseDto userDtoToUserResponseDto(UserDto source);

    CompanyDto companyAssignRequestDtoToCompanyDto(CompanyAssignRequestDto source);

    CompanyListDto companyListRequestDtoToCompanyListDto(CompanyListRequestDto source);

    CompanyResponseDto companyDtoToCompanyResponseDto(CompanyDto source);



    @Mapping(source = "companyProducts", target = "productReferenceList", qualifiedByName = "buildProductReferenseList")
    CompanyDto companyEntityToCompanyDto(CompanyEntity source);

    @Named("buildProductReferenseList")
    default List<String> buildProductReferenseList(List<ProductEntity> list) {
        if (list == null) {
            return null;
        }

        List<String> list1 = new ArrayList(list.size());
        list.forEach((productEntity) -> {
            list1.add(productEntity.getProductRef());
        });
        return list1;
    }


    ProductDto productAssignRequestDtoToProductDto(ProductAssignRequestDto source);

    @Mapping(source = "purchaseRef", target = "purchaseDto.purchaseRef")
    ProductPurchaseDto productPurchaseAssignDtoToProductPurchaseDto(ProductPurchaseAssignDto source);

    default Page<PurchaseResponseDto> purchaseListPageMapper(Page<PurchaseDto> page) {
        return page.map(this::purchaseDtoToPurchaseResponseDto);
    }

    default Page<ProductResponseDto> productListPageMapper(Page<ProductDto> page) {
        return page.map(this::productDtoToProductResponseDto);
    }

    default Page<UserResponseDto> userListPageMapper(Page<UserDto> page) {
        return page.map(this::userDtoToUserResponseDto);
    }

    default Page<CompanyResponseDto> companyListPageMapper(Page<CompanyDto> page) {
        return page.map(this::companyDtoToCompanyResponseDto);
    }

}
