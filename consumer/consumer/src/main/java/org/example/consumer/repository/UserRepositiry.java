package org.example.consumer.repository;

import org.example.consumer.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositiry extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);
}
