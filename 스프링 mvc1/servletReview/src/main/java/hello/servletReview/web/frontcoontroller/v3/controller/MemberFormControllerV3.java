package hello.servletReview.web.frontcoontroller.v3.controller;

import hello.servletReview.web.frontcoontroller.ModelView;
import hello.servletReview.web.frontcoontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
