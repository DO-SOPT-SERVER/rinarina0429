package org.sopt.www.firstspringboot.controller;
// Client에서 보내는 HTTP 요청을 받아 Service 계층에 전달해주고,
// Service 계층에서 처리한 응답을 처리 해주는 Class
import lombok.RequiredArgsConstructor;
import org.sopt.www.firstspringboot.dto.common.CustomResponse;
import org.sopt.www.firstspringboot.dto.request.MemberCreateRequest;
import org.sopt.www.firstspringboot.dto.request.MemberProfileUpdateRequest;
import org.sopt.www.firstspringboot.dto.response.MemberGetResponse;
import org.sopt.www.firstspringboot.service.MemberService;
import org.sopt.www.firstspringboot.dto.common.Type;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 특정 사용자 정보 단건 조회 V1
    @GetMapping("/{memberId}")
    public CustomResponse<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId){
        return CustomResponse.hasData(Type.GET_MEMBER_SUCCESS, memberService.getMemberByIdV1(memberId));
    }

    // 특정 사용자 정보 단건 조회 V2
    @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId){
        return CustomResponse.hasData(Type.GET_MEMBER_SUCCESS, memberService.getMemberByIdV2(memberId));
    }

    // 목록 조회
    @GetMapping
    public CustomResponse<List<MemberGetResponse>> getMembersProfile(){
        return CustomResponse.hasData(Type.GET_MEMBER_LIST_SUCCESS, memberService.getMembers());
    }

    // 생성
    @PostMapping
    public CustomResponse<MemberGetResponse> createMember(@RequestBody MemberCreateRequest request){
        String stringId = memberService.create(request);
        URI location = URI.create(stringId);
        Long memberId = Long.parseLong(stringId);
        return CustomResponse.hasData(Type.CREATE_MEMBER_SUCCESS, memberService.getMemberByIdV3(memberId));
    }

    // 수정
    @PatchMapping("/{memberId}")
    public CustomResponse<MemberGetResponse> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request){
        memberService.updateSOPT(memberId, request);
        return CustomResponse.hasData(Type.UPDATE_MEMBER_SUCCESS, memberService.getMemberByIdV3(memberId));
    }
    // @PathVariable: URI 경로의 일부를 파라미터로 사용할 때 이용(URI 경로에서 값을 가져옴)
    // @RequestBody: JSON 데이터를 원하는 타입의 객체로 변환해야 하는 경우에 사용하며 HTTP 요청의 몸체(body)를 자바 객체로 받을 수 있게 함

    // 삭제
    @DeleteMapping("/{memberId}")
    public CustomResponse deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return CustomResponse.noData(Type.DELETE_MEMBER_SUCCESS);
    }
}