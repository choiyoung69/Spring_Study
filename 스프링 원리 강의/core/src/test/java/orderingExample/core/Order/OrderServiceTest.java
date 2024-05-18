package orderingExample.core.Order;

import orderingExample.core.AppConfig;
import orderingExample.core.member.Grade;
import orderingExample.core.member.Member;
import orderingExample.core.member.MemberService;
import orderingExample.core.member.MemberServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item", 1000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
