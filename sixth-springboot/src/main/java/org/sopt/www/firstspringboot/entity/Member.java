package org.sopt.www.firstspringboot.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id // 해당 field가 식별자(@Entity 가 붙은 클래스에는 반드시 선언)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private int age;

    @Embedded // 공통적으로 관리할 수 있는 필드들은 한 객체의 속성으로 보고, 객체로 관리해주는 것이 좋음
    private SOPT sopt;

    @Builder
    public Member(String name, String nickname, int age, SOPT sopt) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }

    public void updateSOPT(SOPT sopt) {
        this.sopt = sopt;
    }
}
