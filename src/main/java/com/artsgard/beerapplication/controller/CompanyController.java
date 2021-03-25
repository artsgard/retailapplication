package com.artsgard.beerapplication.controller;

import com.artsgard.beerapplication.dto.CompanyListDto;
import com.artsgard.beerapplication.dto.request.CompanyAssignRequestDto;
import com.artsgard.beerapplication.dto.request.CompanyListRequestDto;
import com.artsgard.beerapplication.dto.response.CompanyResponseDto;
import com.artsgard.beerapplication.mapper.DtoMapper;
import com.artsgard.beerapplication.mapper.EntityMapper;
import com.artsgard.beerapplication.service.CompanyService;
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
public class CompanyController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @Autowired
    EntityMapper entityMapper;

    @Autowired
    DtoMapper dtoMapper;

    @PostMapping(path = "/user/{username}/companies", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method assigns a list of companys to an user")
    public ResponseEntity<Boolean> userCompanyAssign(@Valid @ApiParam(value = "User name", required = true) @PathVariable String username,
                                                     @Valid @ApiParam(value = "Assign request") @RequestBody CompanyAssignRequestDto dto) {

        Boolean response = false;
        try {
            response = companyService.userCompanyAssign(username, dtoMapper.companyAssignRequestDtoToCompanyDto(dto));
        } finally {
            if (response) {
                logger.info("The Company assign was successful with username: " + username);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/user/{username}/companies", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "The method unassigns a list of companys from an user")
    public ResponseEntity<Boolean> userCompanyUnassign(@Valid @ApiParam(value = "User name", required = true) @PathVariable String username,
                                                       @Valid @ApiParam(value = "Unassign request") @RequestBody CompanyAssignRequestDto dto) {

        Boolean response = false;
        try {
            response = companyService.userCompanyUnassign(username, dtoMapper.companyAssignRequestDtoToCompanyDto(dto));
        } finally {
            if (response) {
                logger.info("The Company un-assign was successful wit username: " + username);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(path = "/companies", produces = "application/json")
    @ApiOperation(value = "The method generates a list of companies")
    public Page<CompanyResponseDto> userCompanyList(@Valid @ApiParam(value = "Company list request") CompanyListRequestDto dto,
                                                    @PageableDefault() Pageable pageable) {

        Page<CompanyResponseDto> response = null;
        try {
            CompanyListDto companyListDto = dtoMapper.companyListRequestDtoToCompanyListDto(dto);

            if (companyListDto != null) {
                companyListDto.setPageable(pageable);
            }
            companyService.listCompany(companyListDto);

            response = dtoMapper.companyListPageMapper(companyService.listCompany(companyListDto));
        } finally {

        }
        return response;
    }
}
