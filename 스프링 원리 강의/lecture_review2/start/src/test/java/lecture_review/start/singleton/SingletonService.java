package lecture_review.start.singleton;

public class SingletonService {
    private static final SingletonService singletonService = new SingletonService();

    private SingletonService(){

    }

    public static SingletonService getInstance(){
        return singletonService;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
