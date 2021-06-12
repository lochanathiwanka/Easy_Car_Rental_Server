package com.locha.repo;

import com.locha.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request, String> {
}
