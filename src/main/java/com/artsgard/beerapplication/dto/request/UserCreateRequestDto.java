package com.artsgard.beerapplication.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
public class UserCreateRequestDto implements Serializable {
    private static final long serialVersionUID = -4757470046669926020L;

    @NotNull
    @Size(min = 2, max = 20)
    @ApiParam(value = "User name", required = true)
    private String username;

    @NotNull
    @ApiParam(value = "User password", required = true)
    private String password;

    @ApiParam(value = "User first name", required = true)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 40)
    @ApiParam(value = "User last name", required = true)
    private String lastName;

    @NotNull
    @Email
    @ApiParam(value = "User email", required = true)
    private String email;

    @NotNull
    @ApiParam(value = "User is active", required = true)
    private Boolean active;

}