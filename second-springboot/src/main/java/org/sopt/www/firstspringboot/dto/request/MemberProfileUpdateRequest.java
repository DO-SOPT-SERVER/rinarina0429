package org.sopt.www.firstspringboot.dto.request;

import lombok.Data;
import org.sopt.www.firstspringboot.entity.Part;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}
