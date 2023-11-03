package org.sopt.www.firstspringboot.dto.common;

public record CustomResponse<T>(
        int code,
        String status,
        boolean success,
        T data
) {
    // 데이터 없음
    public static CustomResponse<?> noData(Type type) {
        return new CustomResponse<>(type.getCode(), type.getStatus(), type.isSuccess(), null);
    }

    // 데이터 있음
    public static <T> CustomResponse<T> hasData(Type type, T data) {
        return new CustomResponse<>(type.getCode(), type.getStatus(), type.isSuccess(), data);
    }
}