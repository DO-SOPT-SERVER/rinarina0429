package org.sopt.www.firstspringboot.sample;

import lombok.Builder;
import lombok.Getter;
// import lombok.*;
@Getter //lombok annotation만 달아주면 getter, setter 자동 생성
@Builder //.build(), HealthCheckController v4 참고
// @AllArgsConstructor, @RequiredArgsConstructor, @NoArgsConstructor
// Constructors made to order: Generates constructors that take no arguments,
// one argument per final / non-null field, or one argument for every field.
// https://projectlombok.org/features/constructor
// 즉, @RequiredArgsConstructor annotation은 초기화되지 않은 final이나 @NonNull인 필드 값만 parameter로 받는 constructor 생성
// 새로운 필드를 추가할 때 다시 생성자를 생성해야하는 번거로움 없애줌
public class Person {
    private String lastName;
    private String firstName;

    public Person() {}

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
