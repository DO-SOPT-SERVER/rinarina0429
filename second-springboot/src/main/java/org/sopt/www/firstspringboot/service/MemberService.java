package org.sopt.www.firstspringboot.service;
// 비즈니스 로직을 다루고, 특히 데이터베이스 Transaction과 관련된 처리를 담당하는 계층
// Repository 계층에 의존하여 데이터를 받아오고,
// 도메인 계층과의 의존을 통해 데이터를 가공하는 역할도 진행
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.www.firstspringboot.dto.request.*;
import org.sopt.www.firstspringboot.dto.response.*;
import org.sopt.www.firstspringboot.entity.Member;
import org.sopt.www.firstspringboot.entity.SOPT;
import org.sopt.www.firstspringboot.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getMemberByIdV1(Long id){
        Member member = memberJpaRepository.findById(id).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getMemberByIdV2(Long id){
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
    }

    public MemberGetResponse getMemberByIdV3(Long id){
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

    // MemberJpaRepository 에서 findByIdOrThrow 구현하는 것 말고
    // Service 내부에 private 메소드 만드는 방법
    // public MemberGetResponse getMemberByIdV4(Long memberId){
    //    return MemberGetResponse.of(findById(memberId));
    // }

    // private Member findById(Long memberId){
    // return memberJpaRepository.findById(memberId).orElseThrow(
    //             () -> new EntityNotFoundException("해당하는 회원이 없습니다.")
    //     );
    // }

    public List<MemberGetResponse> getMembers(){
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public String create(MemberCreateRequest request){
        Member member = memberJpaRepository.save(Member.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .age(request.getAge())
                .sopt(request.getSopt())
                .build());
        return member.getId().toString();
    }

    //update
    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request){
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.getGeneration(), request.getPart()));
    }

    //delete
    @Transactional
    public void deleteMember(Long memberId){
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }
}
