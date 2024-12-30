package Hello.core.AutoWired;

import Hello.core.member.Member;
import io.micrometer.common.lang.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void autoWiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }


    static class TestBean{
        @Autowired(required=false)
        public void setNoBean1(Member member) {
            System.out.println("setNoBean1 = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("member = " + member);
        }

    }
}
