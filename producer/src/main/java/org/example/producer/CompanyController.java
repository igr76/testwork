package org.example.producer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    CompanyService companyService;
    @GetMapping(value = "/company/{name}")
    public ResponseEntity<CompanyDto> getUser(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok(companyService.getCompany(name));
    }

}
