package hello.hellospring.repository; // repository는 저장소 (회원 저장소)

import hello.hellospring.domain.Member; // option+enter 해서 class import

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);         // id, name 찾아줌
    Optional<Member> findByName(String name);
    List<Member> findAll();                     // 지금까지 member 모두 불러옴

    void clearStore();
}
