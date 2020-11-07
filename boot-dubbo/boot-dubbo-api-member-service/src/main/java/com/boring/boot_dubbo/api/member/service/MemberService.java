package com.boring.boot_dubbo.api.member.service;

import com.boring.boot_dubbo.api.member.entity.Member;

/**
 * @author boring
 * @date 2020/9/24 下午2:54
 */
public interface MemberService {
    /**
     * 获取会员信息
     * @param id
     * @return
     */
    Member getMember(Integer id);
}
