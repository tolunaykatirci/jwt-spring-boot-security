package com.tolu.security.jwtspringbootsecurity.controller;

import com.tolu.security.jwtspringbootsecurity.model.JwtUser;
import com.tolu.security.jwtspringbootsecurity.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping
    public ResponseEntity login(@RequestBody final JwtUser jwtUser){
        // check if user is in database
        if(jwtUser.getUsername().equals("admin") && jwtUser.getPassword().equals("1234")){
            jwtUser.setRole("ROLE_ADMIN");
            jwtUser.setId(1l);
            return ResponseEntity.ok().header("MyToken",jwtGenerator.generate(jwtUser)).body(null);
        } else if (jwtUser.getUsername().equals("user") && jwtUser.getPassword().equals("1234")){
            jwtUser.setRole("ROLE_USER");
            jwtUser.setId(2l);
            return ResponseEntity.ok().header("MyToken",jwtGenerator.generate(jwtUser)).body(null);
        } else {
            return ResponseEntity.badRequest().body(null);
        }

    }
}
