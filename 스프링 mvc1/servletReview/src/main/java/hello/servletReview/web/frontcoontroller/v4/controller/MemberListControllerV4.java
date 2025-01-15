package hello.servletReview.web.frontcoontroller.v4.controller;

import hello.servletReview.domain.member.Member;
import hello.servletReview.domain.member.MemberRepository;
import hello.servletReview.web.frontcoontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();

        model.put("members", members);

        return "members";
    }
}
