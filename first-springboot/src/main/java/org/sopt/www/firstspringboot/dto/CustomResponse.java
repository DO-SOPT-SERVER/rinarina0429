package org.sopt.www.firstspringboot.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomResponse<T> {
    private int code;
    private HttpStatus status;
    private boolean success;
    private T data;

    // 성공(데이터 없음)
    public static CustomResponse<?> ok() {
        return new CustomResponse<>(HttpStatus.OK.value(), HttpStatus.OK, true, null);
    }

    // 성공(데이터 있음)
    public static <T> CustomResponse<T> okData(T data) {
        return new CustomResponse<>(HttpStatus.OK.value(), HttpStatus.OK, true, data);
    }

    // 서버가 요청을 이해할 수 없을 때 (ex. 올바르지 않은 데이터 형식)
    public static CustomResponse<?> error(String message) {
        return new CustomResponse<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, false, message);
    }

    private CustomResponse (int code, HttpStatus status, boolean success, T data) {
        this.code = code;
        this.status = status;
        this.success = success;
        this.data = data;
    }
}