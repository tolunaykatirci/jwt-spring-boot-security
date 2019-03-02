package com.tolu.security.jwtspringbootsecurity.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    @PostAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public String test(){
        return "Test Service OK!";
    }


    @RequestMapping(value = "/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String roleTest(){
        return "Admin Test Service OK!";
    }
}
