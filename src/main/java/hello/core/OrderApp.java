package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderServiceImpl orderService = (OrderServiceImpl) appConfig.orderService();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        MemberService memberService = context.getBean("memberService",MemberService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 1000);
        System.out.println("order = "+order);

    }
}
