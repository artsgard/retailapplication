package com.artsgard.beerapplication.service;

import com.artsgard.beerapplication.dto.UserDto;
import com.artsgard.beerapplication.dto.UserListDto;
import com.artsgard.beerapplication.dto.request.UserCreateRequestDto;
import com.artsgard.beerapplication.dto.request.UserListRequestDto;
import com.artsgard.beerapplication.dto.request.UserUpdateRequestDto;
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