package hello.servletReview.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import org.apache.catalina.filters.ExpiresFilter;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    //startLine 정보
    private void printStartLine(HttpServletRequest request){
        System.out.println("----------Request Start Line ----------- ");

        System.out.println("request.getMethod() " + request.getMethod());
        System.out.println("request.getProtocol() " + request.getProtocol());
        System.out.println("request.getScheme() " + request.getScheme());
        System.out.println("request.getRequestURL() " + request.getRequestURL());
        System.out.println("request.getRequestURI() " + request.getRequestURI());
        System.out.println("request.getQueryString() " + request.getQueryString());
        System.out.println("request.isSecure() " + request.isSecure());
        System.out.println("-----------Request Start Line end -----------");
        System.out.println();
    }

    //관련 헤더 정보
    private void printHeaders(HttpServletRequest request) {
        System.out.println("---------Header start----------------");

//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " + request.getHeader(headerName));
//        }

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName +
                        " : " + request.getHeader(headerName)));
        System.out.println("---------Header end ----------------");
        System.out.println();
    }

    //header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request){
        System.out.println("----------header 편리한 조회-----------------");
        System.out.println("[host 편의 조회]");
        System.out.println("request.getServername() " + request.getServerName());
        System.out.println("request.getServerPort() " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println(
                        "locale : " + locale
                ));
        System.out.println("request.getLocale()" + request.getLocale());

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회");
        System.out.println("request.getContentType() " + request.getContentType());
        System.out.println("request.getContentLength() " + request.getContentLength());
        System.out.println("request.getCharacterEncoding()" + request.getCharacterEncoding());

        System.out.println("--------header 편의 조회 end------------");
        System.out.println();
    }

    //기타 조회
    private void printEtc(HttpServletRequest request){
        System.out.println("----------------기타 조회-----------------");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() " + request.getRemoteAddr());
        System.out.println();

        System.out.println("[Locale 정보]");
        System.out.println("request.getLocalName() " + request.getLocalName());
        System.out.println("request.getLocalAddr() " + request.getLocalAddr());
        System.out.println("request.getLocalPort()" + request.getLocalPort());

        System.out.println("----------기타 조회----------");
        System.out.println();
    }
}
