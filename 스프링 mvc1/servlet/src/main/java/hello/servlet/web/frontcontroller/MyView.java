package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;

    public MyView(String viewPath){
        this.viewPath = viewPath;
    }

    // 기본에 JSP로 이동하고 하는 것을 render한다고 표현함.
    // 기존에 controler에서 하는 로직을 view라는 곳으로 만들어서 넣음
    // JSP로 렌더링하는 부분(View를 만드는 행위자체) => 렌더링한다.
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    public void render(final Map<String, Object> model, final HttpServletRequest request,
                       final HttpServletResponse response) throws ServletException, IOException {
        //model에 있는 데이터를 다 꺼내서 request에 넣기
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    private static void modelToRequestAttribute(final Map<String, Object> model, final HttpServletRequest request) {
        model.forEach(request::setAttribute);
    }
}
