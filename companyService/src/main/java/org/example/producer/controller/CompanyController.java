package org.example.producer.controller;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.example.producer.Exeption.BusinessException;
import org.example.producer.dto.CompanyDto;
import org.example.producer.dto.CompanyDtoAndUsers;
import org.example.producer.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(path = "/company")
public class CompanyController {
    private  CompanyService companyService;
    @GetMapping(value = "/{name}")
    public ResponseEntity<CompanyDto> getCompanyByName(@PathVariable(value = "name") @NonNull String name) throws BusinessException {
        log.debug(String.format("In CompanyController getCompanyByName name=%s  name received successfully"),name);
        CompanyDto responseEntity = null;
        try {
            responseEntity = companyService.getCompanyByName(name);
        } catch (Exception e) {
            throw new BusinessException("error couldn't get the company by name");
        }
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping(value = "/companyThisUsers/{name}")
    public ResponseEntity<CompanyDtoAndUsers> getCompanyByNameWithListUsers(@PathVariable(value = "name") @NonNull String name) throws IOException, BusinessException {
        log.debug(String.format("In CompanyController getCompanyByNameThisUsers name=%s  name received successfully"),name);
        CompanyDtoAndUsers responseEntity = null;
        try {
            responseEntity = companyService.getCompanyByNameWithListEmployees(name);
        } catch (Exception e) {
            throw new BusinessException("error couldn't get the company by name");
        }
        return ResponseEntity.ok(responseEntity);
    }

}
