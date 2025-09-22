package springsms.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springsms.member.Grade;
import springsms.member.Member;
import springsms.member.MemberServiceImpl;
import springsms.member.MemoryMemberRepository;
import springsms.member.MemberService;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
         Member member = new Member(1L, "MemberA", Grade.VIP);

         //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
