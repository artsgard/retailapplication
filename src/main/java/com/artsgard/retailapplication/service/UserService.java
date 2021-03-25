package com.artsgard.retailapplication.service;

import com.artsgard.retailapplication.dto.UserDto;
import com.artsgard.retailapplication.dto.UserListDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 
 * @author WillemDragstra
 */
@Service
public interface UserService {
    UserDto createUser(UserDto dto);
    UserDto updateUser(String userRef, UserDto agencyData);
    UserDto getUser(String userRef); // throws ResourceNotFoundException;
    Page<UserDto> listUser(UserListDto dto);
    Boolean deleteUser(String userRef);
}