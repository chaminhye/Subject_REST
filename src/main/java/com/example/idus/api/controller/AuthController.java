package com.example.idus.api.controller;

import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.dto.req.AuthReqVO;
import com.example.idus.api.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
@Api(tags={"1. 회원가입 및 로그인"})
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation(value="회원가입")
    @PostMapping ("/signup")
    public String signup(@RequestBody AuthReqVO req){
        return "회원가입";
    }

    @ApiOperation(value="로그인")
    @PostMapping ("/login")
    public String login(@ApiParam(value = "회원 이메일", required = true) @RequestParam String email,
                        @ApiParam(value = "회원 비밀번호", required = true) @RequestParam String password){
        UserDTO user = authService.getUserInfo(email);
        if(user != null){
            if(!passwordEncoder.matches(password, user.getPassword())){
                return "계정일치하지 않습니다.";
            }
        }
        return "로그인";
    }
}
