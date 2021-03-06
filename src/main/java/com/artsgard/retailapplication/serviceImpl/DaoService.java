package com.artsgard.retailapplication.serviceImpl;

import com.artsgard.retailapplication.dto.CompanyDto;
import com.artsgard.retailapplication.dto.PurchaseDto;
import com.artsgard.retailapplication.dto.ProductDto;
import com.artsgard.retailapplication.dto.UserDto;
import com.artsgard.retailapplication.entity.CompanyEntity;
import com.artsgard.retailapplication.entity.ProductEntity;
import com.artsgard.retailapplication.entity.PurchaseEntity;
import com.artsgard.retailapplication.entity.UserEntity;
import com.artsgard.retailapplication.exception.ResourceNotFoundException;
import com.artsgard.retailapplication.mapper.DtoMapper;
import com.artsgard.retailapplication.mapper.EntityMapper;
import com.artsgard.retailapplication.repository.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author WillemDragstra
 *
 */
@Service
public abstract class DaoService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DaoService.class);

    @Autowired
    UserRepository userRepo;

    @Autowired
    PurchaseRepository purchaseRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ProductPurchaseRepository productPurchaseRepo;

    @Autowired
    CompanyRepository companyRepo;

    //@Autowired
    //Properties properties;

    @Autowired
    EntityMapper entityMapper;

    @Autowired
    DtoMapper dtoMapper;

    UserDto getUserDto(String username) {

        if (username == null) {
            return null;
        }

        UserEntity  entity = null;
       Optional<UserEntity> optEntity = userRepo.findUserEntityByUsername(username);

        if(optEntity.isPresent()) {
            entity = optEntity.get();
        } else {
            logger.error("No user present with username: " + username);
            throw new ResourceNotFoundException("No user present with username: " + username);
        }

        return dtoMapper.userEntityToUserDto(entity);
    }

    ProductDto getProductDto(String ref) {

        if (ref == null) {
            return null;
        }

       ProductEntity entity = null;
        Optional<ProductEntity> optEntity = productRepo.findProductEntityByProductRef(ref);

        if(optEntity.isPresent()) {
            entity = optEntity.get();
        } else {
            logger.error("No product present with reference: " + ref);
            throw new ResourceNotFoundException("No product present with reference: " + ref);
        }

        return dtoMapper.productEntityToProductDto(entity);
    }

    PurchaseDto getPurchaseDto(String ref) {

        if (ref == null) {
            return null;
        }

        PurchaseEntity entity = null;
        Optional<PurchaseEntity> optEntity = purchaseRepo.findPurchaseEntityByPurchaseRef(ref);

        if(optEntity.isPresent()) {
            entity = optEntity.get();
        } else {
            logger.error("No purchase present with reference: " + ref);
            throw new ResourceNotFoundException("No purchase present with reference: " + ref);
        }

        return dtoMapper.purchaseEntityToPurchaseDto(entity);
    }

    CompanyDto getCompanyDto(String ref) {

        if (ref == null) {
            return null;
        }

        CompanyEntity entity = null;
        Optional<CompanyEntity> optEntity = companyRepo.findCompanyEntityByCompanyRef(ref);

        if(optEntity.isPresent()) {
            entity = optEntity.get();
        } else {
            logger.error("No company present with reference: " + ref);
            throw new ResourceNotFoundException("No company present with reference: " + ref);
        }

        return dtoMapper.companyEntityToCompanyDto(entity);
    }

}
