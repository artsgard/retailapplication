package com.artsgard.retailapplication;

import com.artsgard.retailapplication.dto.request.UserCreateRequestDto;
import com.artsgard.retailapplication.dto.request.UserListRequestDto;
import com.artsgard.retailapplication.dto.request.UserUpdateRequestDto;
import com.artsgard.retailapplication.dto.response.UserResponseDto;
import com.artsgard.retailapplication.repository.CompanyRepository;
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
import com.artsgard.retailapplication.config.IntegrationTest;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureJsonTesters
//@Sql({"/company_data.sql"})
//@Transactional
/*
@Sql(scripts = {"/company_data.sql"},
        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.INFERRED))
@Transactional

*/
public class UserControllerTest extends IntegrationTest {

    @Autowired
    private CompanyRepository companyRepo;

    @Test
    @Order(1)
    public void testLoadDataForTestCase() {
        assertEquals(8, companyRepo.findAll().size());
    }

    @Test
    @Order(2)
    public void testUserCreate_first() {

        UserCreateRequestDto request = getUserCreateRequest(USERNAME_1, PASSWORD_1, FIRST_NAME_1, LAST_NAME_1, EMAIL_1, ACTIVE_1);
        UserResponseDto result = createUser(request);

        assertEquals(request.getUsername(), result.getUsername());

    }

    @Test
    @Order(3)
    public void testUserCompanyAssign() {

        Boolean result = userCompanyAssign(USERNAME_1, COMPANY_LIST);

        assertTrue(result);

    }

    @Test
    @Order(4)
    public void testUserGet_afterAssign() {

        UserResponseDto result = getUser(USERNAME_1);

        assertEquals(result.getUsername(), USERNAME_1);

        assertEquals(3, result.getUserCompanyRefList().size());

    }

    @Test
    @Order(5)
    public void testUserCompanyUnAssign() {

        Boolean result = userCompanyUnassign(USERNAME_1, COMPANY_LIST);

        assertTrue(result);

    }

    @Test
    @Order(6)
    public void testUserGet_afterUnAssign() {

        UserResponseDto result = getUser(USERNAME_1);

        assertEquals(result.getUsername(), USERNAME_1);

        assertEquals(0, result.getUserCompanyRefList().size());

    }

    @Test
    @Order(7)
    public void testUserUpdate_first() {

        UserUpdateRequestDto request = getUserUpdateRequest(USERNAME_1);
        UserResponseDto result = updateUser(USERNAME_1, request);

        assertEquals(request.getUsername(), result.getUsername());

    }

    @Test
    @Order(8)
    public void testUserGet_first() {

        UserResponseDto result = getUser(USERNAME_1);

        assertEquals(result.getUsername(), USERNAME_1);

    }

    @Test
    @Order(9)
    public void testUserDelete_first() {

        Boolean result = deleteUser(USERNAME_1);

        assertTrue(result);

    }


    //@Test
    public void _06_UserRegionAssignTest() {

      /*

        HttpEntity<UserCreateRequestDto> entity = new HttpEntity<>(regionRequest, headers);

        ResponseEntity<UserResponseDto> response = restTemplate.exchange(
                createURLWithPort("/useres/" + "" + "/regions"),
                HttpMethod.POST,
                entity,
                UserResponseDto.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        UserResponseDto result = response.getBody();

        assertNotNull(result);

        assertEquals(regionRequest.getUsername(), result.getUsername());

       */
    }

    //@Test
    public void _07_UserListTest() {
        UserListRequestDto request = new UserListRequestDto();
        request.setUsername(null);
        List<UserResponseDto> users = userList(request);
        assertFalse(users.isEmpty());

        request.setUsername("");
        users = userList(request);
       assertTrue(users.toString().contains(request.getUsername()));

        request.setUsername(null);
        request.setUsername("");
        users = userList(request);
       assertTrue(users.toString().contains(request.getUsername()));
        request.setUsername(null);

       
    }






}


