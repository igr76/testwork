package org.example.producer.repository;

import org.example.producer.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepositiry extends JpaRepository<CompanyEntity,Integer> {
    Optional<CompanyEntity> findByName(String name);
}
