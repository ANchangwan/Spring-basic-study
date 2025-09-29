package hello.singleton;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {



    @Test
    @DisplayName("순수한 di 컨테이너")
    public void testSingleton() {
//        AppConfig appConfig = new AppConfig();

        ApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService1 = context.getBean("memberService", MemberService.class);
        MemberService memberService2 = context.getBean("memberService", MemberService.class);


        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
        //
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void testSingleton2() {
        // given

        //when
        SingleTonService instance1 = SingleTonService.getInstance();
        SingleTonService instance2 = SingleTonService.getInstance();

        //then
        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    
}
