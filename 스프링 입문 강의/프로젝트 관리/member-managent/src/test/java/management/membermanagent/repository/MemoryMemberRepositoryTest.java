package management.membermanagent.repository;

import management.membermanagent.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        //OPtion

        Member result = repository.findById(member.getId()).get();

        //DB에서 꺼낸 것과 그 전 값이 같으면 되는 것임

        //방법 1. 그냥 print해서 true인지 확인하기
        //System.out.println("result= " + (result == member));

        //방법 2. 글자로 보기 그러니까 assert해서 확인하기
        //Assertions.assertEquals(member, result);  // 녹색 불이 뜨면 같음

        //방법3. org.assertj 쓰면 좀 더 편하게 쓸 수 있ㅇ므
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findALL(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
