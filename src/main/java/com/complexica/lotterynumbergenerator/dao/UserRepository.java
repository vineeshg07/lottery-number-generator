package com.complexica.lotterynumbergenerator.dao;

import com.complexica.lotterynumbergenerator.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);
}
