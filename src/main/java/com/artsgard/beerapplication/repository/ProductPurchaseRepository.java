package com.artsgard.beerapplication.repository;

import com.artsgard.beerapplication.entity.ProductEntity;
import com.artsgard.beerapplication.entity.ProductPurchaseEntity;
import com.artsgard.beerapplication.entity.ProductPurchaseEntityId;
import com.artsgard.beerapplication.entity.PurchaseEntity;
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
