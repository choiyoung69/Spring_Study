package management.membermanagent.repository;


import management.membermanagent.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);   //회원을 저장함.

    Optional<Member> findById(Long id);  //id로 찾는 것
    //id가 null인 경우 요즘은 Optional로 감싸서 반환시켜줌

    Optional<Member> findByName(String name);
    List<Member> findAll();  // 지금까지 저장한 모든 list를 불러와줌
}
