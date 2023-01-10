package hi.springagain.repository;

import hi.springagain.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<Member> findByAge(int age) {
        return store.values().stream()
                .filter(member -> member.getAge()==(age))
                .findAny();
    }

    @Override
    public Optional<Member> findBySize(int size) {
        return store.values().stream()
                .filter(member -> member.getSize()==(size))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
