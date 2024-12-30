package lecture_review.start.xml;

import lecture_review.start.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


public class XMLTest {
    @Test
    void xmlAppContext(){
        ApplicationContext ga = new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService = ga.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
