package org.sopt.www.firstspringboot.dto.request;

import org.sopt.www.firstspringboot.entity.SOPT;

// @Data: record 사용하면 이 annotation 굳이 필요 x
public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {
}
