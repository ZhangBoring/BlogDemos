package com.boring.boot_dubbo.api.member.entity;

import java.io.Serializable;

/**
 *
 * dubbo中序列化的实体类必须实现Serializable接口
 * @author boring
 * @date 2020/9/24 下午2:53
 */
public class Member implements Serializable {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
