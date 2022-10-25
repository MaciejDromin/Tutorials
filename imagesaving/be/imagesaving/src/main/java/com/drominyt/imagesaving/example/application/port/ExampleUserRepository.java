package com.drominyt.imagesaving.example.application.port;

import com.drominyt.imagesaving.example.domain.ExampleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleUserRepository extends JpaRepository<ExampleUser, Long> {
}
