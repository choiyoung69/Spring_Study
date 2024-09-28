package review.sprint_start.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import review.sprint_start.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    Optional<Member> findByName(String name);
}
