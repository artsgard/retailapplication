package com.artsgard.beerapplication;

import com.artsgard.beerapplication.dto.request.ProductCreateRequestDto;
import com.artsgard.beerapplication.dto.request.ProductUpdateRequestDto;
import com.artsgard.beerapplication.dto.response.ProductResponseDto;
import com.artsgard.beerapplication.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.artsgard.beerapplication.config.IntegrationTest;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureJsonTesters
public class ProductControllerTest extends IntegrationTest {

    @Autowired
    private ProductRepository productRepo;

    @Test
    @Order(1)
    public void testLoadDataForTestCase() {
        assertEquals(6, productRepo.findAll().size());
    }

    @Test
    @Order(2)
    public void testProductCreate_first() {

        ProductCreateRequestDto request = getProductCreateRequest(NAME_1, PRODUCT_REF_1, DESCRIPTION_1, PRICE_1,
                PROMOTION_1, BEER_TYPE_1, GRADUATION_1, NATIONALITY_1, COMP_REF_1);
        ProductResponseDto result = createProduct(request);

        assertEquals(request.getName(), result.getName());

    }

    @Test
    @Order(3)
    public void testProductCreate_second() {

        ProductCreateRequestDto request = getProductCreateRequest(NAME_2, PRODUCT_REF_2, DESCRIPTION_2, PRICE_2,
                PROMOTION_2, BEER_TYPE_2, GRADUATION_2, NATIONALITY_2, COMP_REF_2);
        ProductResponseDto result = createProduct(request);

        assertEquals(request.getName(), result.getName());

    }

    @Test
    @Order(4)
    public void testProductCreate_third() {

        ProductCreateRequestDto request = getProductCreateRequest(NAME_3, PRODUCT_REF_3, DESCRIPTION_3, PRICE_3,
                PROMOTION_3, BEER_TYPE_3, GRADUATION_3, NATIONALITY_3, COMP_REF_3);
        ProductResponseDto result = createProduct(request);

        assertEquals(request.getName(), result.getName());

    }

    @Test
    @Order(5)
    public void testProductCompanyAssign() {

        Boolean result = productCompanyAssign(COMP_REF_1, PRODUCT_LIST);

        assertTrue(result);

    }

    @Test
    @Order(6)
    public void testProductGet_afterAssign() {

        ProductResponseDto result = getProduct(PRODUCT_REF_1);

        assertEquals(result.getName(), NAME_1);

        assertNotNull(result.getCompanyRef());

    }

    @Test
    @Order(7)
    public void testProductCompanyUnAssign() {

        Boolean result = productCompanyUnassign(COMP_REF_1, PRODUCT_LIST);

        assertTrue(result);

    }

    @Test
    @Order(8)
    public void testProductGet_afterUnAssign() {

        ProductResponseDto result = getProduct(PRODUCT_REF_1);

        assertEquals(result.getName(),NAME_1);

        assertNull(result.getCompanyRef());

    }

    @Test
    @Order(9)
    public void testProductUpdatet() {

        ProductUpdateRequestDto request = getProductUpdateRequest(PRODUCT_REF_1, COMP_REF_2);
        ProductResponseDto result = updateProduct(PRODUCT_REF_1, request);

        assertEquals(request.getName(), result.getName());

    }

    @Test
    @Order(10)
    public void testProductGet_after_update() {

        ProductResponseDto result = getProduct(PRODUCT_REF_1);

        assertEquals(result.getName(), NAME_UPDATE);

    }

    @Test
    @Order(11)
    public void testProductDelete_first() {

        Boolean result = deleteProduct(PRODUCT_REF_1);

        assertTrue(result);

    }

    @Test
    @Order(12)
    public void testProductDelete_second() {

        Boolean result = deleteProduct(PRODUCT_REF_2);

        assertTrue(result);

    }

    @Test
    @Order(13)
    public void testProductDelete_third() {

        Boolean result = deleteProduct(PRODUCT_REF_3);

        assertTrue(result);

    }


    //@Test
    public void _06_ProductRegionAssignTest() {

      /*

        HttpEntity<ProductCreateRequestDto> entity = new HttpEntity<>(regionRequest, headers);

        ResponseEntity<ProductResponseDto> response = restTemplate.exchange(
                createURLWithPort("/useres/" + "" + "/regions"),
                HttpMethod.POST,
                entity,
                ProductResponseDto.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        ProductResponseDto result = response.getBody();

        assertNotNull(result);

        assertEquals(regionRequest.getProductname(), result.getProductname());

       */
    }
/*
    //@Test
    public void _07_ProductListTest() {
        ProductListRequestDto request = new ProductListRequestDto();
        request.setProductname(null);
        List<ProductResponseDto> users = userList(request);
        assertFalse(users.isEmpty());

        request.setProductname("");
        users = userList(request);
        assertTrue(users.toString().contains(request.getProductname()));

        request.setProductname(null);
        request.setProductname("");
        users = userList(request);
        assertTrue(users.toString().contains(request.getProductname()));
        request.setProductname(null);

    }

 */
}


