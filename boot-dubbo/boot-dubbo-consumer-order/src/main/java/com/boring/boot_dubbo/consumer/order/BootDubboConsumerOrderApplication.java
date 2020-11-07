package com.boring.boot_dubbo.consumer.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class BootDubboConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDubboConsumerOrderApplication.class, args);
    }

}
