package com.woowa.study.discount;

import com.woowa.study.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
