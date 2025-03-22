package org.example.producer.service;

import org.example.producer.dto.CompanyDto;

public interface CompanyService {
    CompanyDto getCompanyByName(String name);
}
