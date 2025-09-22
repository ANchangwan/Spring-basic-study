package springsms.member;

public interface MemberRepository {
    void save(Long id, Member member);
    Member findById(Long memberId);
}
