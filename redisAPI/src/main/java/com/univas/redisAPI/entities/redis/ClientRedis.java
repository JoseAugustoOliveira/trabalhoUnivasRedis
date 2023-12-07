package com.univas.redisAPI.entities.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@Builder
@RedisHash
@NoArgsConstructor
@AllArgsConstructor
public class ClientRedis implements Serializable {

    @Id
    @Indexed
    private Long cpf;

    private String name;

    private String email;
}
