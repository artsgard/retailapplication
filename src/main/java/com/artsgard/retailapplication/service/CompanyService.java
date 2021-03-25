package com.artsgard.retailapplication.service;

import com.artsgard.retailapplication.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    Boolean userCompanyAssign(String username, CompanyDto dto);
    Boolean userCompanyUnassign(String username, CompanyDto dto);

    Page<CompanyDto> listCompany(CompanyListDto dto);

}