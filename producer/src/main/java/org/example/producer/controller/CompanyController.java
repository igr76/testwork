package org.example.producer.controller;

import org.example.producer.dto.CompanyDto;
import org.example.producer.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {
    CompanyService companyService;
    @GetMapping(value = "/{name}")
    public ResponseEntity<CompanyDto> getUser(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok(companyService.getCompanyByName(name));
    }

}
