package com.locha.repo;

import com.locha.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByEmailAndPassword(String email, String password);

    @Query(value = "SELECT uid FROM User ORDER BY uid DESC LIMIT 1", nativeQuery = true)
    String geLastUserId();

}
