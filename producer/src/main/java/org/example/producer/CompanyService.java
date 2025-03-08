package org.example.producer;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    CompanyRepositiry companyRepositiry;
    CompanyMapper companyMapper;

    public CompanyDto getCompany(String name) {
        return companyMapper.toDto(companyRepositiry.findByName(name));
    }
}
