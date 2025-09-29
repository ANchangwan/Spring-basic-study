package hello.lifecycle.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class DatabaseConnect1 {
    private String connect;


    public void setConnect(String connect) {
        this.connect = connect;
    }

    public void disconnect() {
        System.out.println("disconnect: "+ connect);
    }

    public void getConnet(){
        System.out.println("getConnet: "+ connect);
    }
    public void call(String message){
        System.out.println("연결 db: "+ connect +", call: "+ message);
    }

    @PostConstruct
    public void init() {
        System.out.println("db start");
        getConnet();
        call("DB가 요청되었습니다.!!");

    }
    @PreDestroy
    public void close() {
        System.out.println("disconnect 요청");
        disconnect();
    }
}
