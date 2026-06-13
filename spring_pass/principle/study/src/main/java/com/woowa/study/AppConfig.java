package com.woowa.study;

import com.woowa.study.discount.DiscountPolicy;
import com.woowa.study.discount.FixDiscountPolicy;
import com.woowa.study.discount.RateDiscountPolicy;
import com.woowa.study.member.MemberRepository;
import com.woowa.study.member.MemberService;
import com.woowa.study.member.MemberServiceImpl;
import com.woowa.study.member.MemoryMemberRepository;
import com.woowa.study.order.OrderService;
import com.woowa.study.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
