package org.sopt.www.firstspringboot.dto.request;

import org.sopt.www.firstspringboot.entity.Part;

public record MemberProfileUpdateRequest(
        int generation,
        Part part
) {
}
