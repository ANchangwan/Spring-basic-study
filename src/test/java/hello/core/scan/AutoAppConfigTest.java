package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = context.getBean("memberService",MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
