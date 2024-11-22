package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Spring bean의 이름을 url 패턴으로 맞춘 것
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {
        System.out.println("OldController.handleRequest");
        //컨트롤러를 호출했는데 view가 없으면 오류
        return new ModelAndView("new-form");
    }
}
