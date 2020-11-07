package com.boring.boot_dubbo.provider.member;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class BootDubboProviderMemberServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDubboProviderMemberServiceImplApplication.class, args);
    }

}
