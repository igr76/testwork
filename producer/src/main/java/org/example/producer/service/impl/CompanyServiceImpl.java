package org.example.producer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.producer.dto.CompanyDto;
import org.example.producer.dto.CompanyDtoAndUsers;
import org.example.producer.dto.CompanyMapper;
import org.example.producer.dto.UserDto;
import org.example.producer.repository.CompanyRepositiry;
import org.example.producer.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);
    @Value("${applycation.user}")
    private String urlUser ;
    CompanyRepositiry companyRepositiry;
    CompanyMapper companyMapper = new CompanyMapper();

    public CompanyServiceImpl(CompanyRepositiry companyRepositiry) {
        this.companyRepositiry = companyRepositiry;
    }

    @Override
    public CompanyDto getCompanyByName(String name) {
        CompanyDto companyDto = new CompanyDto();
        try {
            companyDto=companyMapper.toDto(companyRepositiry.findByName(name));
            log.debug("getCompanyByName:"+companyDto.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return companyDto;
    }
    @Override
    public CompanyDtoAndUsers getCompanyByNameWithEmployees(String name) {
        CompanyDto companyDto = new CompanyDto();
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserDto> userDtoList = new ArrayList<>();
        try {
            companyDto = companyMapper.toDto(companyRepositiry.findByName(name));
            List<Integer> list = companyDto.getListUser();
            UserDto[] userDtos = objectMapper.readValue(new URL(urlUser + "/user/all"), UserDto[].class);

            Arrays.stream(userDtos)
                    .filter(e -> list.stream()
                            .anyMatch(p -> p.equals(e.getId())))
                    .collect(Collectors.toList());
            userDtoList=Arrays.asList(userDtos);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
        CompanyDtoAndUsers companyDtoAndUsers = new CompanyDtoAndUsers();
        companyDtoAndUsers = companyMapper.toDtosThisUsers(companyDto);
        companyDtoAndUsers.setListUsers(userDtoList);

        return companyDtoAndUsers;
    }
}
