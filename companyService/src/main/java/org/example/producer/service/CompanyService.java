package org.example.producer.service;

import org.example.producer.dto.CompanyDto;
import org.example.producer.dto.CompanyDtoAndUsers;

public interface CompanyService {
    CompanyDto getCompanyByName(String name);

    CompanyDtoAndUsers getCompanyByNameWithListEmployees(String name);
}
