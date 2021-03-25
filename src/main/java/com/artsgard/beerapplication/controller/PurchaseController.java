package com.artsgard.beerapplication.controller;

import com.artsgard.beerapplication.dto.PurchaseListDto;
import com.artsgard.beerapplication.dto.request.*;
import com.artsgard.beerapplication.dto.response.PurchaseResponseDto;
import com.artsgard.beerapplication.mapper.DtoMapper;
import com.artsgard.beerapplication.mapper.EntityMapper;
import com.artsgard.beerapplication.service.PurchaseService;
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
public class PurchaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    EntityMapper entityMapper;

    @Autowired
    DtoMapper dtoMapper;

    @PostMapping(path = "/purchase", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method creates a new purchase")
    public ResponseEntity<PurchaseResponseDto>  createPurchase(@Valid @ApiParam(value = "Create request") @RequestBody PurchaseCreateRequestDto dto) {

        PurchaseResponseDto response = null;
        try {
            String username = dto.getUsername();
            response = dtoMapper.purchaseDtoToPurchaseResponseDto(purchaseService.createPurchase(username, dtoMapper.purchaseCreateRequestDtoToPurchaseDto(dto)));
        } finally {
            if (response != null) {
                logger.info("The Purchase creations was successful with referense: " + response.getPurchaseRef());
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/purchase/{purchaseRef}", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method modifies an existing purchase")
    public ResponseEntity<PurchaseResponseDto> updatePurchase(@Valid @ApiParam(value = "Purchase reference", required = true) @PathVariable String purchaseRef,
                                                              @Valid @ApiParam(value = "Update request") @RequestBody PurchaseUpdateRequestDto dto) {

        PurchaseResponseDto response = null;
        try {
            response = dtoMapper.purchaseDtoToPurchaseResponseDto(purchaseService.updatePurchase(purchaseRef, dtoMapper.purchaseUpdateRequestDtoToPurchaseDto(dto)));
        } finally {
            if (response != null) {
                logger.info("The Purchase update was successful with referense: " + purchaseRef);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/purchase/{purchaseRef}", produces = "application/json")
    @ApiOperation(value = "The method gets an existing purchase")
    public ResponseEntity<PurchaseResponseDto> getPurchase(@Valid @ApiParam(value = "Get request", required = true) @PathVariable String purchaseRef) {

        PurchaseResponseDto response = null;
        try {
            response = dtoMapper.purchaseDtoToPurchaseResponseDto(purchaseService.getPurchase(purchaseRef));
        } finally {

        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/purchase", produces = "application/json")
    @ApiOperation(value = "The method generates a list of purchases")
    public Page<PurchaseResponseDto> listPurchase(@Valid @ApiParam(value = "List request") PurchaseListRequestDto dto,
                                               @PageableDefault() Pageable pageable) {
        Page<PurchaseResponseDto> response = null;
        try {
            PurchaseListDto purchaseListDto = dtoMapper.purchaseListRequestDtoToPurchaseListDto(dto);

            if (purchaseListDto != null) {
                purchaseListDto.setPageable(pageable);
            }

            response = dtoMapper.purchaseListPageMapper(purchaseService.listPurchase(purchaseListDto));

        } finally {

        }
        return response;
    }

    @DeleteMapping(path = "/purchase/{purchaseRef}")
    @ApiOperation(value = "The method deletes an existing purchase")
    public ResponseEntity<Boolean> deletePurchase(@Valid @ApiParam(value = "Delete request", required = true) @PathVariable String purchaseRef) {

        Boolean response = null;
        try {
            response = purchaseService.deletePurchase(purchaseRef);
        } finally {
            if (response) {
                logger.info("The Purchase delete was successful with referense: " + purchaseRef);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/purchase/{productref}/products", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method assigns a product to a purchase")
    public ResponseEntity<Boolean> productPurchaseAssign(@Valid @ApiParam(value = "Product reference", required = true) @PathVariable String productref,
                                                         @Valid @ApiParam(value = "Assign request") @RequestBody ProductPurchaseAssignDto dto) {

        Boolean response = false;
        try {
            response = purchaseService.productPurchaseAssign(productref, dtoMapper.productPurchaseAssignDtoToProductPurchaseDto(dto));
        } finally {
            if (response) {
                logger.info("The Purchase assign was successful with product reference: " + productref);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/purchase/{productref}/products", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method unassigns a product from a purchase")
    public ResponseEntity<Boolean> productPurchaseUnassign(@Valid @ApiParam(value = "Product reference", required = true) @PathVariable String productref,
                                                           @Valid @ApiParam(value = "Unassign request") @RequestBody ProductPurchaseAssignDto dto) {

        Boolean response = false;
        try {
            response = purchaseService.productPurchaseUnassign(productref, dtoMapper.productPurchaseAssignDtoToProductPurchaseDto(dto));
        } finally {
            if (response) {
                logger.info("The Purchase un-assign was successful with product reference: " + productref);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}