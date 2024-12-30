package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")  //hello.html에 매핑
    public String hello(Model model){
        model.addAttribute("data", "spring!!!!");
        return "hello";  //templetes/hello.html을 찾는다는 의미(model(data:hello!!!)를 넘기면서
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-templates";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello " + name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }


    static class Hello{
        //Getter
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
