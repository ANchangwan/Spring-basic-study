package hello.singleton;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        //given
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberServiceImpl memberService = context.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = context.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = context.getBean("memberRepository", MemoryMemberRepository.class);

        //when
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = "+memberRepository1);
        System.out.println("orderService -> memberRepository ="+memberRepository2);
        System.out.println("memberRepository -> memberRepository = "+memberRepository);

        //then
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs( memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs( memberRepository);
    }

    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig ac = context.getBean(AppConfig.class);

        System.out.println("bean  = "+ac.getClass());
    }


}

