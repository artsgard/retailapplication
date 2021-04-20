package com.artsgard.retailapplication.serviceImpl;

import com.artsgard.retailapplication.common.Utils;
import com.artsgard.retailapplication.dto.CompanyDto;
import com.artsgard.retailapplication.dto.ProductDto;
import com.artsgard.retailapplication.dto.ProductListDto;
import com.artsgard.retailapplication.entity.ProductEntity;
import com.artsgard.retailapplication.entity.ProductEntity.BeerType;
import com.artsgard.retailapplication.exception.ResourceAlreadyPresentException;
import com.artsgard.retailapplication.exception.ResourceNotFoundException;
import com.artsgard.retailapplication.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.EnumUtils;

/**
 *
 * @author WillemDragstra
 *
 */
@Service
public class ProductServiceImpl extends DaoService implements ProductService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public ProductDto createProduct(ProductDto dto) {
        if (productRepo.findProductEntityByProductRef(dto.getProductRef()).isPresent()) {
            throw new ResourceAlreadyPresentException("This product is already present: " + dto.getProductRef());
        }
        
        if (!EnumUtils.isValidEnum(BeerType.class, dto.getBeerType())) {
            throw new ResourceNotFoundException("The Beertype " + dto.getBeerType() + " is not a correct ENUM type");
        } 

        if (dto.getCompany() != null && dto.getCompany().getCompanyRef() != null) {
            CompanyDto compDto = getCompanyDto(dto.getCompany().getCompanyRef());
            dto.setCompany(compDto);
        } else {
            dto.setCompany(null);
            /*
            logger.error("The company referense is mandatory!");
            throw new ResourceMandatoryException("The company referense is mandatory!");
             */
        }

        dto.setCreationDate(new Timestamp(System.currentTimeMillis()));
        dto.setPromotion(false);

        return dtoMapper.productEntityToProductDto(productRepo.save(entityMapper.productDtoToProductEntity(dto)));
    }

    @Override
    public ProductDto updateProduct(String productRef, ProductDto dto) {

       ProductDto productDto = getProductDto(productRef);

        if (!StringUtils.isEmpty(dto.getName())) {
            productDto.setName(dto.getName());
        }

        if (!StringUtils.isEmpty(dto.getProductRef())) {
            productDto.setProductRef(dto.getProductRef());
        }

        if (!StringUtils.isEmpty(dto.getDescription())) {
            productDto.setDescription(dto.getDescription());
        }

        if (dto.getPromotion() != null) {
            productDto.setPromotion(dto.getPromotion());
        }

        if (dto.getGraduation() != null) {
            productDto.setGraduation(dto.getGraduation());
        }

        if (dto.getNationality() != null) {
            productDto.setNationality(dto.getNationality());
        }

        if (dto.getBeerType() != null) {
            if (!EnumUtils.isValidEnum(BeerType.class, dto.getBeerType())) {
                throw new ResourceNotFoundException("The Beertype " + dto.getBeerType() + " is not a correct ENUM type");
            } else {
                productDto.setBeerType(dto.getBeerType());
            }
            
        }

        if (dto.getPrice() != null) {
            productDto.setPrice(dto.getPrice());
        }

        if (dto.getCompany() != null && dto.getCompany().getCompanyRef() != null) {
            CompanyDto companyDto = getCompanyDto(dto.getCompany().getCompanyRef());
            productDto.setCompany(companyDto);
        }

        return dtoMapper.productEntityToProductDto(productRepo.save(entityMapper.productDtoToProductEntity(productDto)));
    }

    @Override
    public ProductDto getProduct(String productRef) {

        return getProductDto(productRef);
    }

    @Override
    public Page<ProductDto> listProduct(ProductListDto dto) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("productRef", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("promotion", ExampleMatcher.GenericPropertyMatchers.exact());

        Page<ProductEntity> products = productRepo.findAll(
                Utils.preparedListQuery(Example.of(entityMapper.productListDtoToProductEntity(dto), matcher)),
                dto.getPageable()
        );

        return Utils.transformPage(products, dtoMapper::productEntityToProductDto);
    }

    @Override
    public Boolean deleteProduct(String productRef) {

        ProductDto dto = getProductDto(productRef);

        productRepo.delete(entityMapper.productDtoToProductEntity(dto));

        return true;
    }
    @Override
    public Boolean productCompanyAssign(String companyRef, ProductDto dto) {
        CompanyDto companyDtoInstance = getCompanyDto(companyRef);

        List<ProductDto> productDtoList = new ArrayList<>();
        dto.getProductReferenceList().stream().map((productRef) -> getProductDto(productRef))
                .map((productDtoInstance) -> {
            productDtoInstance.setCompany(companyDtoInstance);
            return productDtoInstance;
        }).forEachOrdered((productDtoInstance) -> {
            productDtoList.add(productDtoInstance);
        });
        companyDtoInstance.setCompànyProducts(productDtoList);

        productRepo.saveAll(entityMapper.productDtoListToProductEntityList(productDtoList));

        return true;
    }

    @Override
    public Boolean productCompanyUnassign(String companyRef, ProductDto dto) {
        CompanyDto companyDtoInstance = getCompanyDto(companyRef);

        List<ProductDto> productDtoList = new ArrayList<>();
        List<String> list = dto.getProductReferenceList();
        List<ProductDto> products = companyDtoInstance.getCompànyProducts();
       
        dto.getProductReferenceList().stream().map((productRef) -> getProductDto(productRef))
                .map((productDtoInstance) -> {
            productDtoInstance.setCompany(null);
            return productDtoInstance;
        }).forEachOrdered((productDtoInstance) -> {
            productDtoList.add(productDtoInstance);
        });
      
/*
        List<ProductDto> productDtoList = products
                .stream()
                .filter(e -> {
                    ProductDto productDtoInstance = getProductDto(e.getProductRef());
                    productDtoInstance.setCompany(null);
                    return list.contains(e.getProductRef());
                })
                .collect(Collectors.toList());
 */       
        productRepo.saveAll(entityMapper.productDtoListToProductEntityList(productDtoList));

        return true;
    }
}
