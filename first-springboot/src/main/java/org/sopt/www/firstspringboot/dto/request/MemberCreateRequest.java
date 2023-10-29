package org.sopt.www.firstspringboot.dto.request;

import lombok.Data;
import org.sopt.www.firstspringboot.entity.SOPT;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}
