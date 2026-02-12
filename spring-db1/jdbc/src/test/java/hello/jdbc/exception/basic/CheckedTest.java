package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class CheckedTest {

    @Test
    public void test() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    public void catchedThrow() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyCheckedException.class);
    }

    // Exception을 상속받은 예외는 체크 예외
    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    // checked 예외는 잡거나 던지거나 둘 중 하나를 반드시 선택해야 한다
    static class Service {
        Repository repository = new Repository();

        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedException e) {
                log.info("예외 처리, message={}", e.getMessage(), e);
            }
        }

        // 체크 예외를 밖으로 던지는 코드
        // throws로 명시해줘야 한다
        public void callThrow() throws MyCheckedException {
             repository.call();
        }
    }

    static class Repository {
        public void call() throws MyCheckedException {
            throw new MyCheckedException("ex");
        }
    }
}
