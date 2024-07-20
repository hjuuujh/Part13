package com.zerobase.practice.domain.repository;


import com.zerobase.practice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}