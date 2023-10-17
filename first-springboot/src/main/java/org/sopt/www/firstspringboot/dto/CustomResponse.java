package org.sopt.www.firstspringboot.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomResponse<T> {
    private int code;
    private String status;
    private boolean success;
    private T data;

    // 성공(데이터 없음)
    public static CustomResponse<?> ok(HttpStatus status) {
        return new CustomResponse<>(status.value(), status.getReasonPhrase(), true, null);
    }

    // 성공(데이터 있음)
    public static <T> CustomResponse<T> okData(HttpStatus status, T data) {
        return new CustomResponse<>(status.value(), status.getReasonPhrase(), true, data);
    }

    // 에러
    public static CustomResponse<?> error(HttpStatus status, String message) {
        return new CustomResponse<>(status.value(), status.getReasonPhrase(), false, message);
    }
}