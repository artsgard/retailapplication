package com.artsgard.retailapplication.service;

import com.artsgard.retailapplication.dto.ProductDto;
import com.artsgard.retailapplication.dto.ProductListDto;
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