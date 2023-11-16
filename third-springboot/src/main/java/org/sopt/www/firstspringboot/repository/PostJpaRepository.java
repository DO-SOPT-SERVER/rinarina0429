package org.sopt.www.firstspringboot.repository;

import jakarta.persistence.EntityNotFoundException;
import org.sopt.www.firstspringboot.entity.Member;
import org.sopt.www.firstspringboot.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);

    default Post findByIdOrThrow(Long id){
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
    }
}
