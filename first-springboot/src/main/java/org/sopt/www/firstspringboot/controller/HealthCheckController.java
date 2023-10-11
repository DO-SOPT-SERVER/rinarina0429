package org.sopt.www.firstspringboot.controller;

import org.sopt.www.firstspringboot.dto.HealthCheckResponse;
import org.sopt.www.firstspringboot.sample.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String, String> healthCheck(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v3")
    public String healthCheckV3(){
        Person person = new Person("이", "나경");
        Person person2 = Person.builder()
                .lastName("Lee")
                .firstName("Nakyeong")
                .build();
        return "OK";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckV4(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<HealthCheckResponse> healthCheckV5(){
        return ResponseEntity.ok(new HealthCheckResponse());
    }
}
