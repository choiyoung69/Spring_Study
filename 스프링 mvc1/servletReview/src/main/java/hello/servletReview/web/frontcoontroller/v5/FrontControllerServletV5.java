package hello.servletReview.web.frontcoontroller.v5;

import hello.servletReview.domain.member.MemberRepository;
import hello.servletReview.web.frontcoontroller.ModelView;
import hello.servletReview.web.frontcoontroller.MyView;
import hello.servletReview.web.frontcoontroller.v3.controller.MemberFormControllerV3;
import hello.servletReview.web.frontcoontroller.v3.controller.MemberListControllerV3;
import hello.servletReview.web.frontcoontroller.v3.controller.MemberSaveControllerV3;
import hello.servletReview.web.frontcoontroller.v4.controller.MemberFormControllerV4;
import hello.servletReview.web.frontcoontroller.v4.controller.MemberListControllerV4;
import hello.servletReview.web.frontcoontroller.v4.controller.MemberSaveControllerV4;
import hello.servletReview.web.frontcoontroller.v5.adapter.ControllerV3HandlerAdapter;
import hello.servletReview.web.frontcoontroller.v5.adapter.ControllerV4HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapter();
    }

    private void initHandlerMappingMap(){
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //V4 추가
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapter(){
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object handler = getHandler(request);
        MyHandlerAdapter handlerAdapter = getHandlerAdapter(handler);

        ModelView mv = handlerAdapter.handle(request, response, handler);

        MyView myView = viewResolver(mv.getViewName());
        myView.render(mv.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler){
        for(MyHandlerAdapter adapter : handlerAdapters){
            if(adapter.supports(handler))
                return adapter;
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler = " + handler);
    }

    private MyView viewResolver(String viewName){
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
