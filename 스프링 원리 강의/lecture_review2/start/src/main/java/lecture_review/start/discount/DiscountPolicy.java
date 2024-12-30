package lecture_review.start.discount;

import lecture_review.start.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
