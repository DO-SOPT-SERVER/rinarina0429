package org.sopt.www.firstspringboot.dto.response;

import org.sopt.www.firstspringboot.entity.Member;
import org.sopt.www.firstspringboot.entity.SOPT;

import java.time.LocalDateTime;

public record MemberGetResponse (
        Long id,
        String name,
        LocalDateTime CreatedAt,
        LocalDateTime UpdatedAt,
        String nickname,
        int age,
        SOPT soptInfo
) {
    // of method:
    // 정적 팩토리 메소드 패턴 을 이용하여 Member Entity로 부터 MemberGetResponse DTO를 만드는 메소드
    // 팩토리 메서드의 파라미터로 넘어온 값들을 검증하여 인스턴스를 생성할 때 사용
    public static MemberGetResponse of(Member member){
        return new MemberGetResponse(
                member.getId(),
                member.getName(),
                member.getCreatedAt(),
                member.getUpdatedAt(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
