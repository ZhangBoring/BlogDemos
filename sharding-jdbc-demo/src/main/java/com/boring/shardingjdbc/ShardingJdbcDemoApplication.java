package com.boring.shardingjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 引入Shading Jdbc Spring Boot Starter后，ShardingJdbc会使用自己的数据源配置逻辑，为避免冲突需要在主类中排除掉默认的数据源自动配置类
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShardingJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcDemoApplication.class, args);
    }

}
