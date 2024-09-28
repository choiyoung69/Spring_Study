package review.sprint_start.Configuration;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import review.sprint_start.AOP.TimeTraceAop;
import review.sprint_start.Repository.*;
import review.sprint_start.Service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {
//    private final DataSource dataSource;
//    private final EntityManager em;
//
//    @Autowired
//    public SpringConfiguration(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfiguration(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
////        return new jdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
