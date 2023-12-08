package org.sopt.www.firstspringboot.dto.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

// Enum 활용: https://techblog.woowahan.com/2527/ 참고하기
@Getter
@RequiredArgsConstructor
public enum Type {
    OK(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), true),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), false),
    GET_MEMBER_SUCCESS(HttpStatus.OK.value(), "사용자 정보 조회 성공", true),
    GET_MEMBER_LIST_SUCCESS(HttpStatus.OK.value(), "전체 사용자 정보 조회 성공", true),
    CREATE_MEMBER_SUCCESS(HttpStatus.CREATED.value(), "사용자 정보 생성 성공", true),
    UPDATE_MEMBER_SUCCESS(HttpStatus.OK.value(), "사용자 정보 수정 성공", true),
    DELETE_MEMBER_SUCCESS(HttpStatus.NO_CONTENT.value(), "사용자 정보 삭제 성공", true),
    GET_POST_SUCCESS(HttpStatus.OK.value(), "게시글 조회 성공", true),
    GET_POST_LIST_SUCCESS(HttpStatus.OK.value(), "전체 게시글 조회 성공", true),
    CREATE_POST_SUCCESS(HttpStatus.CREATED.value(), "게시글 생성 성공", true),
    UPDATE_POST_SUCCESS(HttpStatus.OK.value(), "게시글 수정 성공", true),
    DELETE_POST_SUCCESS(HttpStatus.NO_CONTENT.value(), "게시글 삭제 성공", true);

    private final int code;
    private final String status;
    private final boolean success;
}
