package hello.servletReview.web.frontcoontroller.v3.controller;

import hello.servletReview.domain.member.Member;
import hello.servletReview.domain.member.MemberRepository;
import hello.servletReview.web.frontcoontroller.ModelView;
import hello.servletReview.web.frontcoontroller.v3.ControllerV3;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
