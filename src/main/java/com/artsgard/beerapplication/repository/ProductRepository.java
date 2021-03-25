package com.artsgard.beerapplication.repository;

import java.util.Optional;
import com.artsgard.beerapplication.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WillemDragstra
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
    Optional<ProductEntity> findProductEntityByProductRef(String ref);
}
