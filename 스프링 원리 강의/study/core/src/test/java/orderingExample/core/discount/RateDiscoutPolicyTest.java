package orderingExample.core.discount;
import orderingExample.core.member.Grade;
import orderingExample.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


//import static org.assertj.core.api.Assertions.*;
class RateDiscoutPolicyTest {
    RateDiscoutPolicy discountPolicy = new RateDiscoutPolicy();

    @Test
    @DisplayName("VIP는 10%의 할인이 적용되어야 한다.")
    void VIP_10(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void VIP_no(){
        //given
        Member member = new Member(2L, "memberA", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}