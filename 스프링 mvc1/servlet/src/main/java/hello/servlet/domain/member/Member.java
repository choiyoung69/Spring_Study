package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
public class Member {
    private Long id;  //repository 에서 바로 생성
    private String username;
    private int age;

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
