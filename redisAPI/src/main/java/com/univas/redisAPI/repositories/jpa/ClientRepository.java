package com.univas.redisAPI.repositories.jpa;

import com.univas.redisAPI.entities.jpa.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
