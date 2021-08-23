package ru.geekbrains.corelib.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository
@RequiredArgsConstructor
public class RedisRepository {
    final String TOKENS_SET = "tokens";
    Jedis jedis = new Jedis();

    public void saveToken(String token){
        jedis.sadd(TOKENS_SET, token);
    }

    public boolean checkToken(String token) {
        return jedis.sismember (TOKENS_SET, token);
    }
}
