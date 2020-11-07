package com.boring.boot_dubbo.provider.member.service.impl;

import com.boring.boot_dubbo.api.member.entity.Member;
import com.boring.boot_dubbo.api.member.service.MemberService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author boring
 * @date 2020/9/24 下午3:16
 */
@DubboService
public class MemberServiceImpl implements MemberService {
    @Override
    public Member getMember(Integer id) {
        Member member = new Member();
        member.setId(id);
        member.setName("张三");
        return member;
    }
}
