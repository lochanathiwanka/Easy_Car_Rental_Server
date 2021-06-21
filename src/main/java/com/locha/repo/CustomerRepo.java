package com.locha.repo;

import com.locha.entity.Customer;
import com.locha.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, String> {


    Optional<Customer> findByUser(User user);

    @Query(value = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String geLastCid();
}

