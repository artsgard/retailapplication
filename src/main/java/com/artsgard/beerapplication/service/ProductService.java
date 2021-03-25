package com.artsgard.beerapplication.service;

import com.artsgard.beerapplication.dto.CompanyDto;
import com.artsgard.beerapplication.dto.ProductDto;
import com.artsgard.beerapplication.dto.ProductListDto;
import com.artsgard.beerapplication.dto.request.ProductCreateRequestDto;
import com.artsgard.beerapplication.dto.request.ProductListRequestDto;
import com.artsgard.beerapplication.dto.request.ProductUpdateRequestDto;
import com.artsgard.beerapplication.dto.response.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductDto createProduct(ProductDto dto);
    ProductDto updateProduct(String productRef, ProductDto dto);
    ProductDto getProduct(String productRef); // throws ResourceNotFoundException;
    Page<ProductDto> listProduct(ProductListDto dto);
    Boolean deleteProduct(String productRef);

    Boolean productCompanyAssign(String companyRef, ProductDto dto);
    Boolean productCompanyUnassign(String companyRef, ProductDto dto);
}