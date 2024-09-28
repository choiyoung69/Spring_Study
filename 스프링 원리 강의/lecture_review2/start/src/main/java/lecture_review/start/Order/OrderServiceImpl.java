package lecture_review.start.Order;

import lecture_review.start.Annotation.MainDiscountPolicy;
import lecture_review.start.discount.DiscountPolicy;
import lecture_review.start.discount.FixDiscountPolicy;
import lecture_review.start.discount.RateDiscountPolicy;
import lecture_review.start.member.Member;
import lecture_review.start.member.MemberRepository;
import lecture_review.start.member.MemoryMemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    @Getter
    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
