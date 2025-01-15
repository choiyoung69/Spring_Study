package hello.servletReview.web.frontcoontroller.v5.adapter;

import hello.servletReview.web.frontcoontroller.ModelView;
import hello.servletReview.web.frontcoontroller.v4.ControllerV4;
import hello.servletReview.web.frontcoontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.taglibs.standard.lang.jstl.ImplicitObjects.createParamMap;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4)handler;

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewPath = controller.process(paramMap, model);

        ModelView modelView = new ModelView(viewPath);
        modelView.setModel(model);

        return modelView;
    }

    private Map<String, String> createParamMap(HttpServletRequest request){
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(
                        paramName, request.getParameter(paramName)));

        return paramMap;
    }
}
