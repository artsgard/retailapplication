package com.artsgard.beerapplication.config;

import com.artsgard.beerapplication.dto.request.*;
import java.math.BigDecimal;
import java.util.List;

class TestCommonData extends TestCommonConstants {

    protected final UserCreateRequestDto getUserCreateRequest(String username, String password, String firstName, String lastName, String email, Boolean active) {
        UserCreateRequestDto request = new UserCreateRequestDto();
        request.setUsername(username);
        request.setFirstName(firstName);
        request.setPassword(password);
        request.setLastName(lastName);
        request.setEmail(email);
        request.setActive(active);

        return request;
    }

    public final UserUpdateRequestDto getUserUpdateRequest(String username) {
        UserUpdateRequestDto request = new UserUpdateRequestDto();
        request.setUsername(username);
        request.setFirstName(FIRST_NAME_UPDATE);
        request.setLastName(LAST_NAME_UPDATE);
        request.setEmail(EMAIL_UPDATE);
        request.setActive(ACTIVE_UPDATE);

        return request;
    }

    public final UserListRequestDto getUserListRequest(String username, String lastName, String email, Boolean active) {
        UserListRequestDto request = new UserListRequestDto();
        request.setUsername(username);
        request.setLastName(lastName);
        request.setEmail(email);
        request.setActive(active);

        return request;
    }

    public final CompanyAssignRequestDto getCompanyAssignRequest(List<String> list) {
        CompanyAssignRequestDto request = new CompanyAssignRequestDto();
        request.setCompanyReferenceList(list);
        return request;
    }
// Product
    public final ProductCreateRequestDto getProductCreateRequest(String name, String productRef, String description, BigDecimal price,
                                                                 Boolean promotion, String beerType, String graduation, String nationality, String compRef) {
        ProductCreateRequestDto request = new ProductCreateRequestDto();
        request.setName(name);
        request.setProductRef(productRef);
        request.setDescription(description);
        request.setPrice(price);
        request.setPromotion(promotion);
        request.setGraduation(graduation);
        request.setNationality(nationality);
        request.setBeerType(beerType);
        request.setCompanyRef(compRef);

        return request;
    }

    public final ProductUpdateRequestDto getProductUpdateRequest(String productRef, String compRef) {
        ProductUpdateRequestDto request = new ProductUpdateRequestDto();
        request.setProductRef(productRef);
        request.setName(NAME_UPDATE);
        request.setDescription(DESCRIPTION_UPDATE);
        request.setPrice(PRICE_UPDATE);
        request.setPromotion(PROMOTION_UPDATE);
        request.setGraduation(GRADUATION_UPDATE);
        request.setNationality(NATIONALITY_UPDATE);
        request.setBeerType(BEER_TYPE_UPDATE);
        request.setCompanyRef(compRef);

        return request;
    }

    public final ProductListRequestDto getProductListRequest(String name, String productRef, String nationality, String graduation, String beerType, Boolean promtion) {
        ProductListRequestDto request = new ProductListRequestDto();
        request.setProductRef(productRef);
        request.setName(name);
        request.setNationality(nationality);
        request.setGraduation(graduation);
        request.setBeerType(beerType);
        request.setPromotion(promtion);

        return request;
    }

    public final ProductAssignRequestDto getProductAssignRequest(List<String> list) {
        ProductAssignRequestDto request = new ProductAssignRequestDto();
        request.setProductReferenceList(list);
        return request;
    }

}
