package hello.lifecycle.database;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class DatabaseMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        DatabaseConnect1 bean = ac.getBean(DatabaseConnect1.class);
        ac.close();

    }

    @Configuration
    static class AppConfig{
        @Bean
        public DatabaseConnect1 Connect(){
            DatabaseConnect1 connect = new DatabaseConnect1();
            connect.setConnect("데이터베이스 연결");
            return connect;
        }
    }
}
