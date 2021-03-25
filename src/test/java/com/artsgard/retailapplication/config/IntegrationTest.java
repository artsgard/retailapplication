package com.artsgard.retailapplication.config;

import com.artsgard.retailapplication.common.Properties;
import com.artsgard.retailapplication.dto.request.*;
import com.artsgard.retailapplication.dto.response.ProductResponseDto;
import com.artsgard.retailapplication.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest extends TestCommonData {

    @LocalServerPort
    private int port;

    @Autowired
    Properties properties;

    protected HttpHeaders headers = new HttpHeaders();

    @Autowired
    protected TestRestTemplate restTemplate;

    public IntegrationTest() {
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json;charset=UTF-8");

    }

    protected String createURLWithPort(String uri) {
        return "http://localhost:" + port + properties.getApplicationContext() + "beer" + uri;
    }

    //User test
    protected UserResponseDto createUser(UserCreateRequestDto request) {

        HttpEntity<UserCreateRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<UserResponseDto> response = restTemplate.exchange(
                createURLWithPort("/user"), HttpMethod.POST, entity, UserResponseDto.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }

    protected UserResponseDto getUser(String username) {
        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<UserResponseDto> response = restTemplate.exchange(
                createURLWithPort("/user/" + username), HttpMethod.GET, entity, UserResponseDto.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }

    protected Boolean deleteUser(String username) {

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Boolean> response = restTemplate.exchange(
                createURLWithPort("/user/" + username),
                HttpMethod.DELETE,
                entity,
                Boolean.class
        );


        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }

    protected UserResponseDto updateUser(String username, UserUpdateRequestDto request) {

        HttpEntity<UserUpdateRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<UserResponseDto> response = restTemplate.exchange(
                createURLWithPort("/user/" + username), HttpMethod.PUT, entity, UserResponseDto.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        UserResponseDto result = response.getBody();

        return result;

    }

    protected List<UserResponseDto> userList(UserListRequestDto request) {

        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);

        ParameterizedTypeReference<RestPageImpl<UserResponseDto>> responseType =
                new ParameterizedTypeReference<RestPageImpl<UserResponseDto>>() { };

        HttpEntity entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort("/user"))
                .queryParam("literalBranch", request.getUsername() != null ? request.getUsername() : null)
                .queryParam("literaluser", request.getLastName() != null ? request.getLastName() : null)

                .queryParam("page", "0")
                .queryParam("size", "10");
        //.queryParam("sort", "dateCreation,desc");

        ResponseEntity<RestPageImpl<UserResponseDto>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                responseType
        );

        RestPageImpl<UserResponseDto> list = response.getBody();

        List<UserResponseDto> useres = list.getContent();

        assertFalse(useres.isEmpty());

        return useres;

    }

    protected Boolean userCompanyAssign(String username, List<String> list) {
        CompanyAssignRequestDto request = getCompanyAssignRequest(list);

        HttpEntity<CompanyAssignRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Boolean> response = restTemplate.exchange(
                createURLWithPort("/user/" + username + "/companies"), HttpMethod.POST, entity, Boolean.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }

    protected Boolean userCompanyUnassign(String username, List<String> list) {
        CompanyAssignRequestDto request = getCompanyAssignRequest(list);

        HttpEntity<CompanyAssignRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Boolean> response = restTemplate.exchange(
                createURLWithPort("/user/" + username + "/companies"), HttpMethod.DELETE, entity, Boolean.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }


    //Product test
    protected ProductResponseDto createProduct(ProductCreateRequestDto request) {

        HttpEntity<ProductCreateRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ProductResponseDto> response = restTemplate.exchange(
                createURLWithPort("/product"), HttpMethod.POST, entity, ProductResponseDto.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }

    protected ProductResponseDto getProduct(String productRef) {
        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<ProductResponseDto> response = restTemplate.exchange(
                createURLWithPort("/product/" + productRef), HttpMethod.GET, entity, ProductResponseDto.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }

    protected Boolean deleteProduct(String productRef) {

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Boolean> response = restTemplate.exchange(
                createURLWithPort("/product/" + productRef),
                HttpMethod.DELETE,
                entity,
                Boolean.class
        );


        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }

    protected ProductResponseDto updateProduct(String productRef, ProductUpdateRequestDto request) {

        HttpEntity<ProductUpdateRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ProductResponseDto> response = restTemplate.exchange(
                createURLWithPort("/product/" + productRef), HttpMethod.PUT, entity, ProductResponseDto.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        ProductResponseDto result = response.getBody();

        return result;

    }

    protected List<ProductResponseDto> userList(ProductListRequestDto request) {

        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);

        ParameterizedTypeReference<RestPageImpl<ProductResponseDto>> responseType =
                new ParameterizedTypeReference<RestPageImpl<ProductResponseDto>>() { };

        HttpEntity entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort("/user"))
                .queryParam("productRef", request.getProductRef() != null ? request.getProductRef() : null)
                .queryParam("name", request.getName() != null ? request.getName() : null)

                .queryParam("page", "0")
                .queryParam("size", "10");
        //.queryParam("sort", "dateCreation,desc");

        ResponseEntity<RestPageImpl<ProductResponseDto>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                responseType
        );

        RestPageImpl<ProductResponseDto> list = response.getBody();

        List<ProductResponseDto> useres = list.getContent();

        assertFalse(useres.isEmpty());

        return useres;

    }

    protected Boolean productCompanyAssign(String compRef, List<String> list) {
        ProductAssignRequestDto request = getProductAssignRequest(list);

        HttpEntity<ProductAssignRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Boolean> response = restTemplate.exchange( //"/company/{compref}/products"
                createURLWithPort("/company/" + compRef + "/products"), HttpMethod.POST, entity, Boolean.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }

    protected Boolean productCompanyUnassign(String compRef, List<String> list) {
        ProductAssignRequestDto request = getProductAssignRequest(list);

        HttpEntity<ProductAssignRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Boolean> response = restTemplate.exchange(
                createURLWithPort("/company/" + compRef + "/products"), HttpMethod.DELETE, entity, Boolean.class
        );

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        return response.getBody();
    }


}
