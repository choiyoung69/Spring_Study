package Hello.core.singleton;

import Hello.core.AppConfig;
import Hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회 - 호출할 때마다 객체를 생성
        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();

        System.out.println("memberService = " + memberService);
        System.out.println("memberService1 = " + memberService1);

        assertThat(memberService).isNotSameAs(memberService1);
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();
        assertThat(instance1).isSameAs(instance2);

        //same는 == instance 비교
        //equal equals
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void SpringContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        //1. 조회 - 호출할 때마다 객체를 생성
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService = " + memberService);
        System.out.println("memberService1 = " + memberService1);

        //2. Instance 같은 것 확인
        assertThat(memberService).isSameAs(memberService1);
    }
}
