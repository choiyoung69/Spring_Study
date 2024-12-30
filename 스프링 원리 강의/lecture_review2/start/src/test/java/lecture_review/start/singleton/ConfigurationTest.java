package lecture_review.start.singleton;

import lecture_review.start.AppConfig;
import lecture_review.start.Order.OrderService;
import lecture_review.start.Order.OrderServiceImpl;
import lecture_review.start.member.MemberRepository;
import lecture_review.start.member.MemberService;
import lecture_review.start.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {
    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        System.out.println("orderService = " + orderService);
        System.out.println("memberService = " + memberService);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository).isSameAs(memberService.getMemberRepository());
        assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
    }

    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());;
    }
}
