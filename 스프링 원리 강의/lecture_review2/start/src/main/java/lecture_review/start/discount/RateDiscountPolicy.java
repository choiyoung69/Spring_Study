package lecture_review.start.discount;

import lecture_review.start.Annotation.MainDiscountPolicy;
import lecture_review.start.member.Grade;
import lecture_review.start.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        else return 0;
    }
}
