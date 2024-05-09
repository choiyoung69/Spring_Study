package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")  //hello에 매핑
    public String hello(Model model){
        model.addAttribute("data", "spring!!!!");
        return "hello";  //templetes/hello.html을 찾는다는 의미(model(data:hello!!!)를 넘기면서
    }
}
