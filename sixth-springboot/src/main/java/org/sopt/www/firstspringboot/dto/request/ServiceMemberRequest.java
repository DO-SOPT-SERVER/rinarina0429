package org.sopt.www.firstspringboot.dto.request;

public record ServiceMemberRequest(
        String nickname,
        String password
) {
}