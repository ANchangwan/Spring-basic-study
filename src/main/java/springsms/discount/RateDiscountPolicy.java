package springsms.discount;

import springsms.member.Grade;
import springsms.member.Member;

public class RateDiscountPolicy  implements DiscountPolicy {
    private int discountRate = 10;
    @Override
    public int discount(Member member, int price) {
        if(Grade.VIP ==member.getGrade()){
            return price * discountRate / 100;
        }else {
            return 0;
        }

    }
}
