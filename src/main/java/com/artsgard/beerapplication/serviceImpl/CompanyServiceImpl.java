package com.artsgard.beerapplication.serviceImpl;

import com.artsgard.beerapplication.common.Utils;
import com.artsgard.beerapplication.dto.CompanyDto;
import com.artsgard.beerapplication.dto.CompanyListDto;
import com.artsgard.beerapplication.dto.UserDto;
import com.artsgard.beerapplication.entity.CompanyEntity;
import com.artsgard.beerapplication.service.CompanyService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author WillemDragstra
 *
 */
@Service
public class CompanyServiceImpl extends DaoService implements CompanyService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Boolean userCompanyAssign(String username, CompanyDto dto) {

        UserDto userDtoInstance = getUserDto(username);

        List<CompanyDto> companyDtoList = new ArrayList<>();
        dto.getCompanyReferenceList().forEach((compRef) -> {
            companyDtoList.add(getCompanyDto(compRef));
        });
        userDtoInstance.getUserCompanies().addAll(companyDtoList);

        userRepo.save(entityMapper.userDtoToUserEntity(userDtoInstance));

        return true;

    }

    @Override
    public Boolean userCompanyUnassign(String username, CompanyDto dto) {

        UserDto userDtoInstance = getUserDto(username);

        List<String> list = dto.getCompanyReferenceList();
        List<CompanyDto> companys = userDtoInstance.getUserCompanies();

        List<CompanyDto> filteredCompanyData = companys
                .stream()
                .filter(e -> {
                    return !list.contains(e.getCompanyRef());
                })
                .collect(Collectors.toList());

        userDtoInstance.setUserCompanies(filteredCompanyData);
        userRepo.save(entityMapper.userDtoToUserEntity(userDtoInstance));

        return true;
    }

    @Override
    public Page<CompanyDto> listCompany(CompanyListDto dto) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("companyRef", ExampleMatcher.GenericPropertyMatchers.exact());

        Page<CompanyEntity> companies = companyRepo.findAll(
                Utils.preparedListQuery(Example.of(entityMapper.companyListDtoToCompanyEntity(dto), matcher)),
                dto.getPageable()
        );

        return Utils.transformPage(companies, dtoMapper::companyEntityToCompanyDto);

    }
}