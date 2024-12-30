package Hello.core.Order;

import Hello.core.discount.FixDiscountPolicy;
import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "item1", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}