package com.boring.pkg.spring.boot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author boring
 * @date 2020/8/6 下午2:36
 */
@ConfigurationProperties(prefix = MyPackageProperties.BORING_PREFIX)
public class MyPackageProperties {

    public static final String BORING_PREFIX = "boring";

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
