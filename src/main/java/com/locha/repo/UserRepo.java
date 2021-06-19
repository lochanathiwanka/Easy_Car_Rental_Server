package com.locha.repo;

import com.locha.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByEmailAndPassword(String email, String password);

}
