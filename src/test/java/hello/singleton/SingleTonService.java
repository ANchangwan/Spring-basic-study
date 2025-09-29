package hello.singleton;

public class SingleTonService {
    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }
    private SingleTonService() {}

    public void login(){
        System.out.println("싱글톤 실행");
    }
}
