package orderingExample.core.discount;

import orderingExample.core.member.Grade;
import orderingExample.core.member.Member;

public class RateDiscoutPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
