package orderingExample.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import orderingExample.core.Order.Order;
import orderingExample.core.Order.OrderService;
import orderingExample.core.Order.OrderServiceImpl;
import orderingExample.core.member.Grade;
import orderingExample.core.member.Member;
import orderingExample.core.member.MemberService;
import orderingExample.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.caculatePrice());
    }
}
