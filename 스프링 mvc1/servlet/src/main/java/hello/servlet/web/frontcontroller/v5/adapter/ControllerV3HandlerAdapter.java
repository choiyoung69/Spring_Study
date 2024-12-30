package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.ObjectProvider;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(final Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(final HttpServletRequest request, final HttpServletResponse response, Object handler)
            throws ServletException, IOException {

        ControllerV3 controller = (ControllerV3) handler;

        Map<String,String> paramMap = createParamMap(request);

        return controller.process(paramMap);
    }

    private static Map<String, String> createParamMap(final HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        //request에서 파라미터를 가져오는 역할을 해야 됨.
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
