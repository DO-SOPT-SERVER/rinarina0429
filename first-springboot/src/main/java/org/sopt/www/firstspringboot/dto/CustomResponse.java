package org.sopt.www.firstspringboot.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.www.firstspringboot.type.Type;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomResponse<T> {
    private int code;
    private String status;
    private boolean success;
    private T data;

    // 데이터 없음
    public static CustomResponse<?> blank(Type type) {
        return new CustomResponse<>(type.getCode(), type.getStatus(), type.isSuccess(), null);
    }

    // 데이터 있음
    public static <T> CustomResponse<T> data(Type type, T data) {
        return new CustomResponse<>(type.getCode(), type.getStatus(), type.isSuccess(), data);
    }
}