package orderingExample.core.Order;

import orderingExample.core.discount.DiscountPolicy;
import orderingExample.core.discount.FixDiscountPolicy;
import orderingExample.core.discount.RateDiscoutPolicy;
import orderingExample.core.member.Member;
import orderingExample.core.member.MemberRepository;
import orderingExample.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);  //할인이 어떻게 되든 상관 없음

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
