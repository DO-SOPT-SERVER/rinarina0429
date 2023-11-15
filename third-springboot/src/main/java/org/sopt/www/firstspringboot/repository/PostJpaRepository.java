package org.sopt.www.firstspringboot.repository;

import org.sopt.www.firstspringboot.entity.Member;
import org.sopt.www.firstspringboot.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);
}
