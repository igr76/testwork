package org.example.producer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.producer.dto.CompanyDto;
import org.example.producer.dto.CompanyDtoAndUsers;
import org.example.producer.dto.CompanyMapper;
import org.example.producer.dto.UserDto;
import org.example.producer.entity.CompanyEntity;
import org.example.producer.repository.CompanyRepositiry;
import org.example.producer.service.CompanyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Value("${applycation.user}")
    private String urlUser;
    private CompanyRepositiry companyRepositiry;
    private CompanyMapper companyMapper = new CompanyMapper();

    public CompanyServiceImpl(CompanyRepositiry companyRepositiry) {
        this.companyRepositiry = companyRepositiry;
    }

    @Override
    public CompanyDto getCompanyByName(String name) {
        CompanyDto companyDto = new CompanyDto();
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity = companyRepositiry.findByName(name).orElseThrow();
        log.debug(String.format("the company by name=%s was successfully received"), name);

        companyDto = companyMapper.toDto(companyEntity);
        return companyDto;
    }

    @Override
    public CompanyDtoAndUsers getCompanyByNameWithListEmployees(String name) throws IOException {
        CompanyDto companyDto = new CompanyDto();
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserDto> userDtoList = new ArrayList<>();
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity = companyRepositiry.findByName(name).orElseThrow();
        CompanyDtoAndUsers companyDtoWithListEmployees = new CompanyDtoAndUsers();
        if (companyEntity != null) {
            companyDto = companyMapper.toDto(companyEntity);
            List<Integer> list = companyDto.getListUser();
            UserDto[] userDtos = objectMapper.readValue(new URL(urlUser + "/user/all"), UserDto[].class);

            Arrays.stream(userDtos)
                    .filter(e -> list.stream()
                            .anyMatch(p -> p.equals(e.getId())))
                    .collect(Collectors.toList());
            userDtoList = Arrays.asList(userDtos);
            log.debug(String.format("the company by name=%s this employee was successfully received"), name);
            companyDtoWithListEmployees = companyMapper.toDtoListCompanyWithListEmployees(companyDto);
            companyDtoWithListEmployees.setListUsers(userDtoList);
        }


        return companyDtoWithListEmployees;
    }
}
