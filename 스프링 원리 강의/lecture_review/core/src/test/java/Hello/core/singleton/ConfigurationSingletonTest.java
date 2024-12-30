package Hello.core.singleton;

import Hello.core.AppConfig;
import Hello.core.Order.OrderService;
import Hello.core.Order.OrderServiceImpl;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderservice", OrderServiceImpl.class);
        MemberRepository memberRepository2 = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository = memberService.getMemberRepository();
        MemberRepository memberRepository1 = orderService.getMemberRepository();


        //세 개다 모두 같ㅇ느 인스턴스
        assertThat(memberRepository).isSameAs(memberRepository1);
        assertThat(memberRepository).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean);
    }
}
