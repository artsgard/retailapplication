package com.artsgard.retailapplication.repository;

import com.artsgard.retailapplication.entity.ProductEntity;
import com.artsgard.retailapplication.entity.ProductPurchaseEntity;
import com.artsgard.retailapplication.entity.ProductPurchaseEntityId;
import com.artsgard.retailapplication.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WillemDragstra
 *
 */
@Repository
public interface ProductPurchaseRepository extends JpaRepository<ProductPurchaseEntity, ProductPurchaseEntityId>, JpaSpecificationExecutor<ProductPurchaseEntity> {

    ProductPurchaseEntity findProductPurchaseEntityByProductAndPurchase(ProductEntity productEntity, PurchaseEntity purchaseEntity);

}
