package org.sopt.www.firstspringboot.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.www.firstspringboot.dto.request.PostCreateRequest;
import org.sopt.www.firstspringboot.dto.request.PostUpdateRequest;
import org.sopt.www.firstspringboot.dto.response.PostGetResponse;
import org.sopt.www.firstspringboot.entity.Member;
import org.sopt.www.firstspringboot.entity.Post;
import org.sopt.www.firstspringboot.repository.MemberJpaRepository;
import org.sopt.www.firstspringboot.repository.PostJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                        .member(member)
                        .title(request.title())
                        .content(request.content())
                        .build()
        );
        return post.getPostId().toString();
    }

    public List<PostGetResponse> getPosts(Long memberId){
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post))
                .toList();
    }

    public PostGetResponse getById(Long postId){
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        return PostGetResponse.of(post);
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request){
        Post post = postJpaRepository.findByIdOrThrow(postId);
        post.updateContent(request.content());
    }

    @Transactional
    public void deleteById(Long postId){
        Post post = postJpaRepository.findByIdOrThrow(postId);
        postJpaRepository.delete(post);
    }
}
