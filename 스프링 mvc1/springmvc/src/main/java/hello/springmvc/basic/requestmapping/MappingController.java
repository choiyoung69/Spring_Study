package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MappingController {

    //url로 매핑
    @RequestMapping(value = "/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGet2(){
        log.info("mappingGetV2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId = {} ", data);
        return "ok";
    }

    @GetMapping("/mapping/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable String userId, @PathVariable String orderId){
        log.info("mappingPath userId = {} ", userId);
        log.info("mappingPath orderId = {}", orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mapping Param");
        return "ok";
    }


    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }


    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
