package lecture_review.start.discount;

import lecture_review.start.member.Grade;
import lecture_review.start.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) return discountAmount;
        else return 0;
    }
}
