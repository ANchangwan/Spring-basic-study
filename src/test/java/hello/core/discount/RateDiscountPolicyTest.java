package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip discount 10%")
    public void vipDiscount10Percent() {
        Member member = new Member(1L, "memberVip", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }
}
