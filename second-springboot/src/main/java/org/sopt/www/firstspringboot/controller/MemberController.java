package org.sopt.www.firstspringboot.controller;
// Client에서 보내는 HTTP 요청을 받아 Service 계층에 전달해주고,
// Service 계층에서 처리한 응답을 처리 해주는 Class
import lombok.RequiredArgsConstructor;
import org.sopt.www.firstspringboot.dto.request.MemberCreateRequest;
import org.sopt.www.firstspringboot.dto.request.MemberProfileUpdateRequest;
import org.sopt.www.firstspringboot.dto.response.MemberGetResponse;
import org.sopt.www.firstspringboot.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 특정 사용자 정보 단건 조회 V1
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV1(memberId));
    }

    // 특정 사용자 정보 단건 조회 V2
    @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberGetResponse> getMemberByIdV2(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }

    // 생성
    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request){
        URI location = URI.create(memberService.create(request));
        return ResponseEntity.created(location).build();
    }

    // 목록 조회
    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    // 수정
    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request){
        memberService.updateSOPT(memberId, request);
        return ResponseEntity.noContent().build();
    }
    // @PathVariable: URI 경로의 일부를 파라미터로 사용할 때 이용(URI 경로에서 값을 가져옴)
    // @RequestBody: JSON 데이터를 원하는 타입의 객체로 변환해야 하는 경우에 사용하며 HTTP 요청의 몸체(body)를 자바 객체로 받을 수 있게 함

    // 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}