<<<<<<< HEAD
package orderingExample.core;

import orderingExample.core.Order.OrderService;
import orderingExample.core.Order.OrderServiceImpl;
import orderingExample.core.discount.FixDiscountPolicy;
import orderingExample.core.member.MemberService;
import orderingExample.core.member.MemberServiceImpl;
import orderingExample.core.member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
=======
package orderingExample.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import orderingExample.core.Order.OrderService;
import orderingExample.core.Order.OrderServiceImpl;
import orderingExample.core.discount.DiscountPolicy;
import orderingExample.core.discount.FixDiscountPolicy;
import orderingExample.core.discount.RateDiscoutPolicy;
import orderingExample.core.member.MemberRepository;
import orderingExample.core.member.MemberService;
import orderingExample.core.member.MemberServiceImpl;
import orderingExample.core.member.MemoryMemberRepository;


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
	public DiscountPolicy discountPolicy(){
		return new RateDiscoutPolicy();
	}
}
>>>>>>> 2b206b599fb4d194eed7ed6861ca7c85171aa53f
