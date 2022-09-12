package com.team4.user_service;

import com.team4.user_service.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    List<User> findUsersByRoleEquals(String role);
}
