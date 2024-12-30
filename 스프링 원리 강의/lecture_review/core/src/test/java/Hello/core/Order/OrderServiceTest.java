package Hello.core.Order;

import Hello.core.AppConfig;
import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;


    @BeforeEach
    public void beforeeach(){
        AppConfig appconfig = new AppConfig();
        memberService= appconfig.memberService();
        orderService = appconfig.orderservice();

    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }


}
