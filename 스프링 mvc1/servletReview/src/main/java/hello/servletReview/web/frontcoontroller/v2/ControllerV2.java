package hello.servletReview.web.frontcoontroller.v2;

import hello.servletReview.web.frontcoontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {
    MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
