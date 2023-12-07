package com.univas.redisAPI.services.redis;

import com.univas.redisAPI.entities.redis.ClientRedis;
import com.univas.redisAPI.repositories.redis.ClientRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientRedisService {

    private final ClientRedisRepository clientRedisRepository;

    public ClientRedis save(ClientRedis client) {
        return clientRedisRepository.save(client);
    }

    public List<ClientRedis> findAll() {
        long startTime = System.nanoTime();

        List<ClientRedis> clientes = (List<ClientRedis>) clientRedisRepository.findAll();

        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;

        log.info("Tempo de processamento do findAll(): {} ns", elapsedTime);

        return clientes;
    }

    public void popular10Clients() {
        popularClients(10);
    }

    public void popular10_2Clients() {
        popularClients2(10);
    }

    public void popular100Clients() {
        popularClients(100);
    }

    public void popular1000Clients() {
        popularClients(1000);
    }

    public void popular10000Clients() {
        popularClients(10000);
    }

    public void popular100000Clients() {
        popularClients(100000);
    }

    public void popular1000000Clients() {
        popularClients(1000000);
    }

    @Transactional
    private void popularClients(int numberOfClients) {
        long startTime = System.currentTimeMillis();

        IntStream.range(0, numberOfClients)
                .mapToObj(i -> new ClientRedis(12345678901L + i, "Nome do cliente " + i, "email@cliente.com.br " + i))
                .forEach(cliente -> clientRedisRepository.save(cliente));

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        log.info("Tempo de processamento save: {} ms", elapsedTime);
    }

    @Transactional
    public void popularClients2(int numberOfClients) {
        long startTime = System.currentTimeMillis();

        List<ClientRedis> clientes = IntStream.range(0, numberOfClients)
                .mapToObj(i -> new ClientRedis(12345678901L + i, "Nome do cliente " + i, "email@cliente.com.br " + i))
                .collect(Collectors.toList());

        clientRedisRepository.saveAll(clientes);

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        log.info("Tempo de processamento saveAll: {} ms", elapsedTime);
    }

    public void deleteAll() {
        long startTime = System.nanoTime();

        clientRedisRepository.deleteAll();

        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;

        log.info("Tempo de processamento do deleteAll(): {} ns", elapsedTime);
        System.out.println();
    }
}
