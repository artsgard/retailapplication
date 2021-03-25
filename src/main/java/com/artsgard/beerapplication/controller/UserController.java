package com.artsgard.beerapplication.controller;

import com.artsgard.beerapplication.dto.UserListDto;
import com.artsgard.beerapplication.dto.request.UserCreateRequestDto;
import com.artsgard.beerapplication.dto.request.UserListRequestDto;
import com.artsgard.beerapplication.dto.request.UserUpdateRequestDto;
import com.artsgard.beerapplication.dto.response.UserResponseDto;
import com.artsgard.beerapplication.mapper.DtoMapper;
import com.artsgard.beerapplication.mapper.EntityMapper;
import com.artsgard.beerapplication.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/beer")
public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    EntityMapper entityMapper;

    @Autowired
    DtoMapper dtoMapper;

    @PostMapping(path = "/user", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method creates a new user")
    public ResponseEntity<UserResponseDto> createUser(@Valid @ApiParam(value = "Create request") @RequestBody UserCreateRequestDto dto) {

        UserResponseDto response = null;
        try {
            response = dtoMapper.userDtoToUserResponseDto(userService.createUser(dtoMapper.userCreateRequestDtoToUserDto(dto)));
        } finally {
            if (response != null) {
                logger.info("The user creations was successful with username: " + response.getUsername());
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/user/{username}", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method modifies an existing user")
    public ResponseEntity<UserResponseDto>  updateUser(@Valid @ApiParam(value = "User name", required = true) @PathVariable String username,
                                                       @Valid @ApiParam(value = "Update request") @RequestBody UserUpdateRequestDto dto) {

        UserResponseDto response = null;
        try {
            response = dtoMapper.userDtoToUserResponseDto(userService.updateUser(username, dtoMapper.userUpdateRequestDtoToUserDto(dto)));
        } finally {
            if (response != null) {
                logger.info("The user update was successful with username: " + username);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/user/{username}", produces = "application/json")
    @ApiOperation(value = "The method gets an existing user")
    public ResponseEntity<UserResponseDto> getUser(@Valid @ApiParam(value = "Get request", required = true) @PathVariable String username) {

        UserResponseDto response = null;
        try {
            response = dtoMapper.userDtoToUserResponseDto(userService.getUser(username));
        } finally {

        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/user", produces = "application/json")
    @ApiOperation(value = "The method generates a list of users")
    public Page<UserResponseDto> listUser(@Valid @ApiParam(value = "List request") UserListRequestDto dto, @PageableDefault() Pageable pageable) {
        Page<UserResponseDto> response = null;
        try {
            UserListDto userListDto = dtoMapper.userListRequestDtoToUserListDto(dto);

            if (userListDto != null) {
                userListDto.setPageable(pageable);
            }
            response = dtoMapper.userListPageMapper(userService.listUser(userListDto));
        } finally {

        }
        return response;
    }

    @DeleteMapping(path = "/user/{username}")
    @ApiOperation(value = "The method deletes an existing user")
    public ResponseEntity<Boolean> deleteUser(@Valid @ApiParam(value = "Delete request", required = true) @PathVariable String username) {

        Boolean response = null;
        try {
            response = userService.deleteUser(username);
        } finally {
            if (response != null) {
                logger.info("The user delete was successful with username: " + username);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}