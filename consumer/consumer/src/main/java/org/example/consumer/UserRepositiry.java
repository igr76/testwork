package org.example.consumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositiry extends JpaRepository<UserEntity, Integer> {
}
