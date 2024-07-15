package orderingExample.core.discount;

import orderingExample.core.member.Member;

public interface DiscountPolicy {
    /*
    * @return이 할인 대상 금액
    * */
    int discount(Member member, int price);
}
