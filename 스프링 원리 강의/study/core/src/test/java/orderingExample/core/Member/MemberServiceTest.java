package orderingExample.core.Member;

import orderingExample.core.AppConfig;
import orderingExample.core.member.Grade;
import orderingExample.core.member.Member;
import orderingExample.core.member.MemberService;
import orderingExample.core.member.MemberServiceImpl;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {

    MemberService memberService;
<<<<<<< HEAD

=======
>>>>>>> 2b206b599fb4d194eed7ed6861ca7c85171aa53f
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
<<<<<<< HEAD
    //emberService memberService = new MemberServiceImpl();
=======

>>>>>>> 2b206b599fb4d194eed7ed6861ca7c85171aa53f
    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);

    }
}
