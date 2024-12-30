package lecture_review.start;

import lecture_review.start.Order.Order;
import lecture_review.start.Order.OrderService;
import lecture_review.start.Order.OrderServiceImpl;
import lecture_review.start.member.Grade;
import lecture_review.start.member.Member;
import lecture_review.start.member.MemberService;
import lecture_review.start.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);


        Long memberId = 1L;

        Member member = new Member(memberId, "member", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);;
    }
}
