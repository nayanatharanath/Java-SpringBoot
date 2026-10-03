package com.example.springboot_lombok.repository;

import com.example.springboot_lombok.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
