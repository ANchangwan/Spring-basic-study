package hello.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest{
    @Test
    public void testBeanLifeCycle() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        NetworkClient networkClient = context.getBean("networkClient", NetworkClient.class);
        context.close();
    }



    @Configuration
    static class Config {
        // destroyMethod close 명시하지 않아도 close 찾아서 작동
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://127.0.0.1:8080");
            return networkClient;
        }
    }
}
