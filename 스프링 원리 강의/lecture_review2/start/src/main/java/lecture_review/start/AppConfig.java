package lecture_review.start;

import lecture_review.start.Order.Order;
import lecture_review.start.Order.OrderService;
import lecture_review.start.Order.OrderServiceImpl;
import lecture_review.start.discount.DiscountPolicy;
import lecture_review.start.discount.FixDiscountPolicy;
import lecture_review.start.discount.RateDiscountPolicy;
import lecture_review.start.member.MemberRepository;
import lecture_review.start.member.MemberService;
import lecture_review.start.member.MemberServiceImpl;
import lecture_review.start.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),
                                    discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
