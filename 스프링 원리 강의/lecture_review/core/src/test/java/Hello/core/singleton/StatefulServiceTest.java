package Hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    @DisplayName("무상태를 어겼을 때 발생하는 오류")
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자 10000원 주문
        bean1.order("userA", 10000);
        //ThreadB : B 사용자 20000원 주문
        bean2.order("userB", 20000);

        //ThreadA : 사용자 A 주문 금액 조회
        int price = bean1.getPrice();
        System.out.println("price = " + price);

        assertThat(bean1.getPrice()).isEqualTo(20000);
    }


    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}