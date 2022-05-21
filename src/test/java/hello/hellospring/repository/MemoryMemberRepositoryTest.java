package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach                  // 각 testcase 실행을 위해 method 하나 끝나면 데이터 clear하고 다른 method test
    public void afterEach(){
        repository.clearStore();
    }

    @Test   // @test(org.junit...) -> 아래거를 실행할 수 있음
    public void save(){
        Member member = new Member();
        member.setName("spring");   // 괄호안에서 ctrl(command)+shift+enter치면 바로 엔터처짐

        repository.save(member);

        Member result = repository.findById(member.getId()).get();  // optional에서 꺼낼 때 get()으로 꺼낼 수 있음
        assertThat(member).isEqualTo(result);   // Assertions 치고 option+enter 눌러줘서 import 해준거

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  // shift+fn+f6 누르면 이름 전체변경
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
