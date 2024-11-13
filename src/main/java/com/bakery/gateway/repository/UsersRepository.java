package com.bakery.gateway.repository;

import com.bakery.gateway.entity.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Long, UsersEntity> {
    Optional<UsersEntity> findByUsername(String name);
}
