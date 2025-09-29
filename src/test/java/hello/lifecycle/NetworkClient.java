package hello.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url : "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void connect() {
        System.out.println("connecting to " + url);
    }

    public void disconnect() {
        System.out.println("disconnecting from " + url);
    }

    public void call(String message) {
        System.out.println("calling " + url + "  message: " + message );

    }
    @PostConstruct
    public void init(){
        System.out.println("network init");
        connect();
        call("network 호출");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("network destroy");
        disconnect();
    }
}
