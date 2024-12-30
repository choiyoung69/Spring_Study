package review.sprint_start.Service;


//서비스의 기능은 회원가입(중복회원조회), 전체회원조회가 있다.
import org.springframework.transaction.annotation.Transactional;
import review.sprint_start.Repository.MemberRepository;
import review.sprint_start.Repository.MemoryMemberRepository;
import review.sprint_start.domain.Member;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    //외부에서 memberRepository 주입
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
