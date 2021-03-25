package com.artsgard.beerapplication.repository;

import java.util.Optional;
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
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long>, JpaSpecificationExecutor<PurchaseEntity> {

   Optional<PurchaseEntity> findPurchaseEntityByPurchaseRef(String ref);

}
