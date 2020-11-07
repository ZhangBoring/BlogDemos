package com.boring.boot_dubbo.consumer.order.controller;

import com.boring.boot_dubbo.api.member.entity.Member;
import com.boring.boot_dubbo.api.member.service.MemberService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boring
 * @date 2020/9/24 下午3:27
 */
@RestController
public class OrderController {

    @DubboReference
    private MemberService memberService;

    @GetMapping("/getMember")
    public Member getMember(Integer id) {
        return memberService.getMember(id);
    }
}
