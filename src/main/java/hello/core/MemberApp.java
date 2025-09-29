package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberServiceImpl memberService = (MemberServiceImpl) appConfig.memberService();

        ApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberServiceImpl memberService = context.getBean("memberService", MemberServiceImpl.class);


        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember: "+ findMember.getName());
        System.out.println("new Member: "+ member.getName());
    }
}
