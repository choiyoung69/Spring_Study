package lecture_review.start.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient /*implements InitializingBean, DisposableBean*/ {
    @Setter
    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출 url = " + url);
    }

    public void connect(){
        System.out.println("connect url = " + url);
    }

    public void call(String message){
        System.out.println("call " + url + "message = " + message);
    }
    
    public void disconnect(){
        System.out.println("close = " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }



//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 메세지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }
}
