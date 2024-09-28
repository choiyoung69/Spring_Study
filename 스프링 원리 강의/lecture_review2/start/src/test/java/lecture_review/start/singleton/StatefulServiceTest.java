package lecture_review.start.singleton;

import lecture_review.start.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.naming.spi.StateFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleTon(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("memberA", 10000);
        statefulService2.order("memberB", 20000);

        int price = statefulService1.getPrice();

        System.out.println(price);
        assertThat(price).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
