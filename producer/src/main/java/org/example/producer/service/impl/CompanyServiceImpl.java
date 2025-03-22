package org.example.producer.service.impl;

import org.example.producer.dto.CompanyDto;
import org.example.producer.dto.CompanyMapper;
import org.example.producer.repository.CompanyRepositiry;
import org.example.producer.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);
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
}
