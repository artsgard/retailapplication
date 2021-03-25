package com.artsgard.retailapplication.controller;

import com.artsgard.retailapplication.dto.ProductListDto;
import com.artsgard.retailapplication.dto.request.*;
import com.artsgard.retailapplication.dto.response.ProductResponseDto;
import com.artsgard.retailapplication.mapper.DtoMapper;
import com.artsgard.retailapplication.mapper.EntityMapper;
import com.artsgard.retailapplication.service.CompanyService;
import com.artsgard.retailapplication.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/beer")
public class ProductController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ProductService productService;

    @Autowired
    CompanyService companyService;

    @Autowired
    EntityMapper entityMapper;

    @Autowired
    DtoMapper dtoMapper;

    @PostMapping(path = "/product", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method creates a new product")
    public ResponseEntity<ProductResponseDto>  createProduct(@Valid @ApiParam(value = "Create request (beer-type:  PILS, HELLES, STARKBIER, ALTBIER, DUNKELBIER)") @RequestBody ProductCreateRequestDto dto) {

        ProductResponseDto response = null;
        try {
            response = dtoMapper.productDtoToProductResponseDto(productService.createProduct(dtoMapper.productCreateRequestDtoToProductDto(dto)));
        } finally {
            if (response != null) {
                logger.info("The Product creations was successful with referense: " + response.getProductRef());
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/product/{productRef}", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method modifies an existing product")
    public ResponseEntity<ProductResponseDto> updateProduct(@Valid @ApiParam(value = "Product reference", required = true) @PathVariable String productRef,
                                                            @Valid @ApiParam(value = "Update request (beer-type:  PILS, HELLES, STARKBIER, ALTBIER, DUNKELBIER)") @RequestBody ProductUpdateRequestDto dto) {

        ProductResponseDto response = null;
        try {
            response = dtoMapper.productDtoToProductResponseDto(productService.updateProduct(productRef, dtoMapper.productUpdateRequestDtoToProductDto(dto)));
        } finally {
            if (response != null) {
                logger.info("The Product update was successful with referense: " + productRef);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/product/{productRef}", produces = "application/json")
    @ApiOperation(value = "The method gets an existing product")
    public ResponseEntity<ProductResponseDto> getProduct(@Valid @ApiParam(value = "Get request", required = true) @PathVariable String productRef) {

        ProductResponseDto response = null;
        try {
            response = dtoMapper.productDtoToProductResponseDto(productService.getProduct(productRef));
        } finally {

        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/product", produces = "application/json")
    @ApiOperation(value = "The method generates a list of products")
    public Page<ProductResponseDto> listProduct(@Valid @ApiParam(value = "List request") ProductListRequestDto dto, @PageableDefault() Pageable pageable) {
        Page<ProductResponseDto> response = null;
        try {
            ProductListDto productListDto = dtoMapper.productListRequestDtoToProductListDto(dto);

            if (productListDto != null) {
                productListDto.setPageable(pageable);
            }
            response = dtoMapper.productListPageMapper(productService.listProduct(productListDto));

        } finally {

        }
        return response;
    }

    @DeleteMapping(path = "/product/{productRef}")
    @ApiOperation(value = "The method deletes an existing product")
    public ResponseEntity<Boolean> deleteProduct(@Valid @ApiParam(value = "Delete request", required = true) @PathVariable String productRef) {

        Boolean response = null;
        try {
            response = productService.deleteProduct(productRef);

        } finally {
            if (response) {
                logger.info("The Product delete was successful with referense: " + productRef);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/company/{compref}/products", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method assigns a list of products to a company")
    public ResponseEntity<Boolean> productCompanyAssign(@Valid @ApiParam(value = "Company reference", required = true) @PathVariable String compref,
                                                        @Valid @ApiParam(value = "Assign request") @RequestBody ProductAssignRequestDto dto) {

        Boolean response = false;
        try {
            response = productService.productCompanyAssign(compref, dtoMapper.productAssignRequestDtoToProductDto(dto));
        } finally {
            if (response) {
                logger.info("The company to product assign was successful with company referense: " + compref);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/company/{compref}/products", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method unassigns a list of products from a company")
    public ResponseEntity<Boolean> productCompanyUnassign(@Valid @ApiParam(value = "Company reference", required = true) @PathVariable String compref,
                                                          @Valid @ApiParam(value = "List unassign request") @RequestBody ProductAssignRequestDto dto) {

        Boolean response = false;
        try {
            response = productService.productCompanyUnassign(compref, dtoMapper.productAssignRequestDtoToProductDto(dto));
        } finally {
            if (response) {
                logger.info("The company form product un-assign was successful with company reference: " + compref);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
