package org.example.producer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepositiry extends JpaRepository<CompanyEntity,Integer> {
    CompanyEntity findByName(String name);
}
