package org.example.producer.service;

import org.example.producer.dto.CompanyDto;
import org.example.producer.dto.CompanyDtoAndUsers;

import java.io.IOException;
import java.net.MalformedURLException;

public interface CompanyService {
    CompanyDto getCompanyByName(String name);

    CompanyDtoAndUsers getCompanyByNameWithListEmployees(String name) throws MalformedURLException, IOException;
}
