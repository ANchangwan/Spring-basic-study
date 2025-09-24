package springsms.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springsms.member.Grade;
import springsms.member.Member;
import springsms.member.MemberService;
import springsms.member.MemberServiceImpl;

public class OrderServiceTest {
     MemberService memberService =new MemberServiceImpl();
     OrderService orderService =new OrderServiceImpl();

     @Test
    void createOrder() {
         Long memberId = 1L;
         Member member = new Member(memberId, "itemA", Grade.VIP);
         Order order = orderService.createOrder(memberId, "ItemA", 10000);
         Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
     }
}
