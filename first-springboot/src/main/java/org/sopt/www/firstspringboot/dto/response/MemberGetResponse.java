package org.sopt.www.firstspringboot.dto.response;

import org.sopt.www.firstspringboot.entity.Member;
import org.sopt.www.firstspringboot.entity.SOPT;

public record MemberGetResponse (
        String name,
        String nickname,
        int age,
        SOPT soptInfo
) {
    public static MemberGetResponse of(Member member){
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
