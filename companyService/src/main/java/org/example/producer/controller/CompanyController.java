package org.example.producer.controller;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<CompanyDto> getCompanyByName(@PathVariable(value = "name") @NonNull String name) {
        log.debug(String.format("In CompanyController getCompanyByName name=%s  name received successfully"),name);
        return ResponseEntity.ok(companyService.getCompanyByName(name));
    }

    @GetMapping(value = "/companyThisUsers/{name}")
    public ResponseEntity<CompanyDtoAndUsers> getCompanyByNameWithListUsers(@PathVariable(value = "name") @NonNull String name) throws IOException {
        log.debug(String.format("In CompanyController getCompanyByNameThisUsers name=%s  name received successfully"),name);
        return ResponseEntity.ok(companyService.getCompanyByNameWithListEmployees(name));
    }

}
