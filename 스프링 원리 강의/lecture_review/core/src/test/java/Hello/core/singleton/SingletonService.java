package Hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); //클래스 레벨에서 공유함.

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logit(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
