package com.boring.pkg.spring.boot.starter;

import com.boring.pkg.ClassA;
import com.boring.pkg.ClassBRefClassA;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author boring
 * @date 2020/8/6 下午2:43
 */
@Configuration
@EnableConfigurationProperties(MyPackageProperties.class)
public class MyPackageAutoConfiguration {
    @Bean
    public ClassA getClassA(MyPackageProperties properties) {
        ClassA cA = new ClassA();
        cA.setStr(properties.getStr());
        return cA;
    }

    @Bean
    public ClassBRefClassA getClassB(ClassA cA) {
        ClassBRefClassA cB = new ClassBRefClassA();
        cB.setcA(cA);
        return cB;
    }
}
