package hello.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);

        TestBean acBean = ac.getBean("autowiredTest.TestBean",TestBean.class);

        String[] beanNames = ac.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println("name: " +name);
        }
    }

    @Configuration
    @ComponentScan(basePackageClasses = AutowiredTest.class) // 같은 패키지 스캔
    static class AppConfig {
    }

    @Component
    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
