package hello.servletReview.web.frontcoontroller.v3.controller;

import hello.servletReview.domain.member.Member;
import hello.servletReview.domain.member.MemberRepository;
import hello.servletReview.web.frontcoontroller.ModelView;
import hello.servletReview.web.frontcoontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);

        return modelView;
    }
}
