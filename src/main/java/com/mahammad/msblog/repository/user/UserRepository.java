package com.mahammad.msblog.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDao, Integer> {

    Optional<UserDao> findByEmail(String email);
}
