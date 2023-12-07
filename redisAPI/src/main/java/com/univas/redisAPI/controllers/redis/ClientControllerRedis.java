package com.univas.redisAPI.controllers.redis;

import com.univas.redisAPI.entities.redis.ClientRedis;
import com.univas.redisAPI.services.redis.ClientRedisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
@Tag(name = "Client Redis Controller")
public class ClientControllerRedis {

    private final ClientRedisService redisService;

    @Operation(summary = "Save Client to Redis")
    @PostMapping("/saveRedis")
    public ClientRedis saveRedis(@RequestBody ClientRedis redis) {
        return redisService.save(redis);
    }

    @Operation(summary = "List Clients to Redis")
    @GetMapping()
    public List<ClientRedis> findAllRedis() {
        return redisService.findAll();
    }

    @Operation(summary = "Insert 10 Client to Redis")
    @PostMapping("/popular10Clients")
    public void popular10Clients() {
        redisService.popular10Clients();
    }

    @Operation(summary = "Insert 10 SAVEALL Client to Redis")
    @PostMapping("/popular10Clients_2")
    public void popular10_2Clients() {
        redisService.popular10_2Clients();
    }

    @Operation(summary = "Insert 100 Client to Redis")
    @PostMapping("/popular100Clients")
    public void popular100Clients() {
        redisService.popular100Clients();
    }

    @Operation(summary = "Insert 1000 Client to Redis")
    @PostMapping("/popular1000Clients")
    public void popular1000Clients() {
        redisService.popular1000Clients();
    }

    @Operation(summary = "Insert 10000 Client to Redis")
    @PostMapping("/popular10000Clients")
    public void popular10000Clients() {
        redisService.popular10000Clients();
    }

    @Operation(summary = "Insert 100000 Client to Redis")
    @PostMapping("/popular100000Clients")
    public void popular100000Clients() {
        redisService.popular100000Clients();
    }

    @Operation(summary = "Insert 1000000 Client to Redis")
    @PostMapping("/popular1000000Clients")
    public void popular1000000Clients() {
        redisService.popular1000000Clients();
    }

    @Operation(summary = "Delete all Clients to Redis")
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        redisService.deleteAll();
    }
}
