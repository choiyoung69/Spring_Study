package review.sprint_start.repositoryTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import review.sprint_start.Repository.MemoryMemberRepository;
import review.sprint_start.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("Spring");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("Spring1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findByAll(){
         //given
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("member2");
        repository.save(member2);

        Member member3 = new Member();
        member1.setName("member3");
        repository.save(member3);

        //when
        List<Member> all = repository.findAll();

        assertThat(all.size()).isEqualTo(3);
    }
}
