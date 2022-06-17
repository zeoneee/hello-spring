package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();   // member 저장
    private static long sequence = 0L;      // sequence는 0,1,2를 생성해주는 애들

    @Override
    public Member save(Member member) {
        member.setId((++sequence));         // store에 넣기 전에 member의 id를 setting
        store.put(member.getId(), member);  // hashmap에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // store.get(id)가 null일 경우를 대비해 optional로 감쌈
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 없으면 optional에 null이 포함돼서 반환됨
        // loop 돌려서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 member들 반환
    }

    public void clearStore(){
        store.clear();  // store 싹 비우는
    }
}

// class 옆에 implements MemberRepository 쓰고 option+enter 하면 우리가 쓴 함수들이 불러와짐
// 여기서 함수 구현