package management.membermanagent.repository;

import management.membermanagent.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {
    // 실무에서는 동시성 문제로 인해 공유 변수일 때 컨커런트HashMap 써야함
    private static Map<Long, Member> store = new HashMap<>();
    //sequence는 0,1,2 등등의 값을 생성해주는 애
    //실무에서는 동시성 문제로 인해서 어텀long을 사용해줘야 함.
    private static long sequnce = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequnce);  //save하기 전에 name은 회원가입할 때 저장하는 것
        //id는 시스템이 저장해주는 것.
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //없으면 null
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();  //이름이 찾아지면 그냥 반환, 안되면 null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
