package org.sopt.www.firstspringboot.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

// Enum 활용: https://techblog.woowahan.com/2527/ 참고하기
@Getter
@RequiredArgsConstructor
public enum Type {
    OK(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), true),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), false);

    private final int code;
    private final String status;
    private final boolean success;
}
