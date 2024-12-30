package review.sprint_start.Repository;

import org.springframework.stereotype.Repository;
import review.sprint_start.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static long sequence = 0L;
    private static Map<Long, Member> store = new HashMap<>();  // 얘가 데이터베이스

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
               .filter(member -> member.getName().equals(name))
               .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
