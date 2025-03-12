package com.example.sistema_estoque.repository;

import com.example.sistema_estoque.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
