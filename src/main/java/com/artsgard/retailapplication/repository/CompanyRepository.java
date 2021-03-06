package com.artsgard.retailapplication.repository;

import com.artsgard.retailapplication.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author WillemDragstra
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>, JpaSpecificationExecutor<CompanyEntity> {
    Optional<CompanyEntity> findCompanyEntityByCompanyRef(String ref);
}
