package org.sopt.www.firstspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PresignedUrlVO {
    private String fileName;
    private String url;

    public static PresignedUrlVO of(String fileName, String url) {
        return PresignedUrlVO.builder()
                .fileName(fileName)
                .url(url)
                .build();
    }
}