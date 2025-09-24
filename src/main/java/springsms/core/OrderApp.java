package springsms.core;

import springsms.member.Grade;
import springsms.member.Member;
import springsms.member.MemberService;
import springsms.member.MemberServiceImpl;
import springsms.order.Order;
import springsms.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 1000);
        System.out.println("order = "+order);

    }
}
