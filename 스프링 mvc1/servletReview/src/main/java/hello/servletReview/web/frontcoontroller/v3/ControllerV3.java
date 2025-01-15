package hello.servletReview.web.frontcoontroller.v3;

import hello.servletReview.web.frontcoontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
