package com.boring.boot_sentinel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author boring
 * @date 2020/9/15 下午2:06
 */
@RestController
public class RedisSentinelController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/redis/set")
    public Boolean set(String key) {
        redisTemplate.opsForValue().set(key, "test");
        return true;
    }

    @GetMapping("/redis/get")
    public String get(String key) {
        System.out.println(redisTemplate.getRequiredConnectionFactory().getConnection().info("server"));
        return redisTemplate.opsForValue().get(key);
    }
}
