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
