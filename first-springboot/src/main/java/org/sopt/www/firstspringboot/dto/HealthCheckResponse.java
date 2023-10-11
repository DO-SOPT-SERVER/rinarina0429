package org.sopt.www.firstspringboot.dto;

import lombok.Getter;

@Getter
public class HealthCheckResponse {
    private static final String STATUS = "OK";
    private String status;

    public HealthCheckResponse(){
        this.status = STATUS;
    }

    public HealthCheckResponse(String status) {
        this.status = status;
    }
}
