package com.woowa.study.discount;

import com.woowa.study.member.Grade;
import com.woowa.study.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercenet = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercenet / 100;
        }
        return 0;
    }
}
