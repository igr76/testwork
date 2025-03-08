package org.example.producer;

public class CompanyMapper {
    public CompanyEntity toEntity(CompanyDto companyDto) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(companyDto.getName());
        companyEntity.setBudget(companyDto.getBudget());
        companyEntity.setListUser(companyDto.getListUser());
        return companyEntity;
    }

    public CompanyDto toDto(CompanyEntity companyEntity) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName(companyEntity.getName());
        companyDto.setBudget(companyEntity.getBudget());
        companyDto.setListUser(companyEntity.getListUser());
        return companyDto;
    }
}
