package com.artsgard.retailapplication.serviceImpl;

import com.artsgard.retailapplication.common.Utils;
import com.artsgard.retailapplication.dto.*;
import com.artsgard.retailapplication.entity.ProductPurchaseEntity;
import com.artsgard.retailapplication.entity.PurchaseEntity;
import com.artsgard.retailapplication.exception.ResourceAlreadyPresentException;
import com.artsgard.retailapplication.exception.ResourceNotFoundException;
import com.artsgard.retailapplication.service.PurchaseService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.sql.Timestamp;
import java.util.Random;

/**
 *
 * @author WillemDragstra
 *
 */
@Service
public class PurchaseServiceImpl extends DaoService implements PurchaseService {

    //public static final int RAND = Integer.MAX_VALUE;
    public static final int RAND = 1000;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

    @Override
    public PurchaseDto createPurchase(String username, PurchaseDto dto) {

        if (purchaseRepo.findPurchaseEntityByPurchaseRef(dto.getPurchaseRef()).isPresent()) {
            logger.error("No purchase present with reference: " + dto.getPurchaseRef());
            throw new ResourceAlreadyPresentException("No purchase present with reference: " + dto.getPurchaseRef());
        }

       UserDto userDto = getUserDto(username);

        dto.setPurchaseDate(new Timestamp(System.currentTimeMillis()));
        dto.setCreated(new Timestamp(System.currentTimeMillis()));
        dto.setActive(true);
        dto.setPurchaseRef("purchase-ref-" + new Random().nextInt(RAND));
        dto.setUserDto(userDto);

        return dtoMapper.purchaseEntityToPurchaseDto(purchaseRepo.save(entityMapper.purchaseDtoToPurchaseEntity(dto)));
    }

    @Override
    public PurchaseDto updatePurchase(String purchaseRef, PurchaseDto dto) {

        PurchaseDto purchaseDto = getPurchaseDto(purchaseRef);

        if (!StringUtils.isEmpty(dto.getPurchaseDetails())) {
            purchaseDto.setPurchaseDetails(dto.getPurchaseDetails());
        }

        if (dto.getActive() != null) {
            purchaseDto.setActive(dto.getActive());
        }

        return dtoMapper.purchaseEntityToPurchaseDto(purchaseRepo.save(entityMapper.purchaseDtoToPurchaseEntity(purchaseDto)));
    }

    @Override
    public PurchaseDto getPurchase(String purchaseRef) {

        return getPurchaseDto(purchaseRef);
    }

    @Override
    public Page<PurchaseDto> listPurchase(PurchaseListDto dto) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("purchaseRef", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("state", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("purchaseDetails", ExampleMatcher.GenericPropertyMatchers.exact());

        Page<PurchaseEntity> purchases = purchaseRepo.findAll(
                Utils.preparedListQuery(Example.of(entityMapper.purchaseListDtoToPurchaseEntity(dto), matcher)),
                dto.getPageable()
        );

        return Utils.transformPage(purchases, dtoMapper::purchaseEntityToPurchaseDto);
    }

    @Override
    public Boolean deletePurchase(String purchaseRef) {

        PurchaseDto dto = getPurchaseDto(purchaseRef);

        purchaseRepo.delete(entityMapper.purchaseDtoToPurchaseEntity(dto));

        return true;
    }

    @Override
    public Boolean purchaseToUserAssign(String purchaseRef, PurchaseDto dto) {
        return null;
    }

    @Override
    public Boolean purchaseToUserUnassign(String purchaseRef, PurchaseDto dto) {
        return null;
    }


    @Override
    public Boolean productPurchaseAssign(String productRef, ProductPurchaseDto dto) {

        ProductDto productDtoInstance = getProductDto(productRef);
        PurchaseDto purchaseDtoInstance = null;

        if (dto.getPurchaseDto().getPurchaseRef() != null) {
            purchaseDtoInstance = getPurchaseDto(dto.getPurchaseDto().getPurchaseRef());
        } else {
            logger.error("No purchase referense present!");
            throw new ResourceNotFoundException("No purchase referense present!");
        }

        ProductPurchaseDto productPurchaseDto = new ProductPurchaseDto();
        productPurchaseDto.setProductPurchaseDate(new Timestamp(System.currentTimeMillis()));
        productPurchaseDto.setProductDto(productDtoInstance);
        productPurchaseDto.setPurchaseDto(purchaseDtoInstance);

        ProductPurchaseEntity entity = entityMapper.productPurchaseDtoToProductPurchaseEntity(productPurchaseDto);
        entity.setId(entityMapper.buildProductPurchaseEntityId(productPurchaseDto));

        productPurchaseRepo.save(entity);

        return true;
    }

    @Override
    public Boolean productPurchaseUnassign(String productRef, ProductPurchaseDto dto) {
        ProductDto productDtoInstance = getProductDto(productRef);
        PurchaseDto purchaseDtoInstance = null;

        if (dto.getPurchaseDto().getPurchaseRef() != null) {
            purchaseDtoInstance = getPurchaseDto(dto.getPurchaseDto().getPurchaseRef());
        } else {
            logger.error("No purchase referense present!");
            throw new ResourceNotFoundException("No purchase referense present");
        }

        ProductPurchaseDto productPurchaseDto = new ProductPurchaseDto();
        productPurchaseDto.setProductDto(productDtoInstance);
        productPurchaseDto.setPurchaseDto(purchaseDtoInstance);

        ProductPurchaseEntity entity = productPurchaseRepo.findProductPurchaseEntityByProductAndPurchase(entityMapper.productDtoToProductEntity(productDtoInstance),
                entityMapper.purchaseDtoToPurchaseEntity(purchaseDtoInstance));

        productPurchaseRepo.delete(entity);

        return true;
    }
}