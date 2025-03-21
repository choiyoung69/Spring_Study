package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);
    @RequestMapping("/log-test")
    public String logTest(){
        String name = "String";

        log.trace("trace log {}", name);
        log.debug("debug log {}", name);  //개발 서버에서 봐야할 정보일 때
        log.info(" info log = {}", name); //중요한 비지니스 정보거나 운영 시스템에서 봐야할 정보일 떄
        log.warn("warn log {}", name);  //경고
        log.error("error log {}", name); //에러

        return "ok";
    }
}
