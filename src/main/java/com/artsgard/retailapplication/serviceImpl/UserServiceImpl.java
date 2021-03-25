package com.artsgard.retailapplication.serviceImpl;

import com.artsgard.retailapplication.common.Utils;
import com.artsgard.retailapplication.dto.UserDto;
import com.artsgard.retailapplication.dto.UserListDto;
import com.artsgard.retailapplication.entity.UserEntity;
import com.artsgard.retailapplication.exception.ResourceAlreadyPresentException;
import com.artsgard.retailapplication.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.sql.Timestamp;

/**
 *
 * @author WillemDragstra
 *
 */
@Service
public class UserServiceImpl extends DaoService implements UserService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDto createUser(UserDto dto) {

        if (userRepo.findUserEntityByUsername(dto.getUsername()).isPresent()) {
            logger.error("The user is already present with username: " + dto.getUsername());
            throw new ResourceAlreadyPresentException("The user is already present with username: " + dto.getUsername());
        }

        dto.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        dto.setActive(true);

        return dtoMapper.userEntityToUserDto(userRepo.save(entityMapper.userDtoToUserEntity(dto)));
    }

    @Override
    public UserDto updateUser(String userRef, UserDto dto) {

        UserDto userDto = getUserDto(userRef);

        if (!StringUtils.isEmpty(dto.getUsername())) {
            userDto.setUsername(dto.getUsername());
        }

        if (!StringUtils.isEmpty(dto.getFirstName())) {
            userDto.setFirstName(dto.getFirstName());
        }

        if (!StringUtils.isEmpty(dto.getLastName())) {
            userDto.setLastName(dto.getLastName());
        }

        if (!StringUtils.isEmpty(dto.getEmail())) {
            userDto.setEmail(dto.getEmail());
        }

        if (!StringUtils.isEmpty(dto.getActive())) {
            userDto.setActive(dto.getActive());
        }

        return dtoMapper.userEntityToUserDto(userRepo.save(entityMapper.userDtoToUserEntity(userDto)));
    }

    @Override
    public UserDto getUser(String userRef) {

        return getUserDto(userRef);
    }

    @Override
    public Page<UserDto> listUser(UserListDto dto) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("active", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.exact());

        Page<UserEntity> users = userRepo.findAll(
                Utils.preparedListQuery(Example.of(entityMapper.userListDtoToUserEntity(dto), matcher)),
                dto.getPageable()
        );

        return Utils.transformPage(users, dtoMapper::userEntityToUserDto);
    }

    @Override
    public Boolean deleteUser(String userRef) {

        UserDto dto = getUserDto(userRef);

        userRepo.delete(entityMapper.userDtoToUserEntity(dto));

        return true;
    }
}
