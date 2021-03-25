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
public class UserListRequestDto implements Serializable {
    private static final long serialVersionUID = 7001606785010099141L;

    @ApiParam(value = "User name")
    private String username;

    @ApiParam(value = "Last name")
    private String lastName;

    @ApiParam(value = "email")
    private String email;

    @ApiParam(value = "Is active")
    private Boolean active;

}