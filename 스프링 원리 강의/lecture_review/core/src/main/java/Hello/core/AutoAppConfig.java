package Hello.core;

import Hello.core.Order.OrderService;
import Hello.core.Order.OrderServiceImpl;
import Hello.core.discount.DiscountPolicy;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        basePackages = "Hello.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Autowired MemberRepository memberRepository;
//    @Autowired
//    DiscountPolicy discountPolicy;
//
//
//    @Bean
//    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }


}
