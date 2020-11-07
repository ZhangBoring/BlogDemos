package com.boring.starter.test;

import com.boring.pkg.ClassBRefClassA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author boring
 */
@SpringBootApplication
public class MyStarterTestApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MyStarterTestApplication.class, args);
        ClassBRefClassA cB = applicationContext.getBean(ClassBRefClassA.class);
        cB.print();
    }
}
