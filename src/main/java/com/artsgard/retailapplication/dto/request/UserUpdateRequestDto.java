package com.artsgard.retailapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.io.Serializable;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
public class UserUpdateRequestDto implements Serializable {
    private static final long serialVersionUID = 245818925934065821L;

    @ApiParam(value = "User name")
    private String username;

    @ApiParam(value = "First name")
    private String firstName;

    @ApiParam(value = "Last name")
    private String lastName;

    @ApiParam(value = "email")
    private String email;

    @ApiParam(value = "Is active")
    private Boolean active;

}