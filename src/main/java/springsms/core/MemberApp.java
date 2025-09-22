package springsms.core;

import springsms.member.Grade;
import springsms.member.Member;
import springsms.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember: "+ findMember.getName());
        System.out.println("new Member: "+ member.getName());
    }
}
