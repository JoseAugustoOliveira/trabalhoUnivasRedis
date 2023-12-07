package com.univas.redisAPI.repositories.redis;

import com.univas.redisAPI.entities.redis.ClientRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRedisRepository extends CrudRepository<ClientRedis, Long> {
    void deleteAll();
}
