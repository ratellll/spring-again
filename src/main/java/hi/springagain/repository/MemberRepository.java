package hi.springagain.repository;

import hi.springagain.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    Optional<Member> findByAge(int age);

    Optional<Member> findBySize(int size);

    List<Member> findAll();



}
