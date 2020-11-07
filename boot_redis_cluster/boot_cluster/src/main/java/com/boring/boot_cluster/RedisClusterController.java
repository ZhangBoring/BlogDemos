package com.boring.boot_cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boring
 * @date 2020/9/15 下午5:07
 */
@RestController
public class RedisClusterController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/redis/set")
    public Boolean set() {
        redisTemplate.opsForValue().set("test1", "test1");
        redisTemplate.opsForValue().set("test2", "test2");
        redisTemplate.opsForValue().set("test3", "test3");
        return true;
    }

    @GetMapping("/redis/get")
    public Boolean get() {
        System.out.println(redisTemplate.opsForValue().get("test1"));
        System.out.println(redisTemplate.opsForValue().get("test2"));
        System.out.println(redisTemplate.opsForValue().get("test3"));
        return true;
    }
}
