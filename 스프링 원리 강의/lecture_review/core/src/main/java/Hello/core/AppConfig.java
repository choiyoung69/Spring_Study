package Hello.core;

import Hello.core.Order.OrderService;
import Hello.core.Order.OrderServiceImpl;
import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderservice(){
        System.out.println("AppConfig.orderservice");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
