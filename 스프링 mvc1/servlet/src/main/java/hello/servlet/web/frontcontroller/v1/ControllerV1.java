package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    //구현을 여러 개 하기 위해서 interface로 만듦.
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
