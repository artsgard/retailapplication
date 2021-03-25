package com.artsgard.retailapplication.service;

import com.artsgard.retailapplication.dto.PurchaseDto;
import com.artsgard.retailapplication.dto.PurchaseListDto;
import com.artsgard.retailapplication.dto.ProductPurchaseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseService {
   PurchaseDto createPurchase(String username, PurchaseDto dto);
   PurchaseDto updatePurchase(String purchaseRef, PurchaseDto dto);
   PurchaseDto getPurchase(String purchaseRef); // throws ResourceNotFoundException;
   Page<PurchaseDto> listPurchase(PurchaseListDto dto);
   Boolean deletePurchase(String purchaseRef);

   Boolean purchaseToUserAssign(String purchaseRef, PurchaseDto dto);
   Boolean purchaseToUserUnassign(String purchaseRef, PurchaseDto dto);

   Boolean productPurchaseAssign(String productRef, ProductPurchaseDto dto);
   Boolean productPurchaseUnassign(String productRef, ProductPurchaseDto dto);

}