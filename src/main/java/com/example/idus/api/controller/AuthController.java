package com.example.idus.api.controller;

import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.dto.req.AuthReqVO;
import com.example.idus.api.jwt.JwtTokenUtil;
import com.example.idus.api.service.AuthService;
import com.example.idus.config.response.service.ResponseService;
import com.example.idus.config.response.vo.CommonResult;
import com.example.idus.config.response.vo.SingleResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth/")
@Api(tags={"1. 회원가입 및 로그인"})
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value="회원가입")
    @PostMapping ("/signup")
    public CommonResult signup(@RequestBody AuthReqVO req){
        int result = authService.saveUser(req);
        return result > 0 ? responseService.getSuccessResult() : responseService.getFailResult(500, "error");
    }

    @ApiOperation(value="로그인", notes="이메일로 회원 로그인")
    @PostMapping ("/login")
    public CommonResult login(@RequestBody AuthReqVO req){
        UserDTO user = authService.getUserInfo(req);
/*
        if(user != null){
            String encPwd = passwordEncoder.encode(req.getPassword());
            if(!passwordEncoder.matches(encPwd, "{bcrypt}" +user.getPassword())){
                return responseService.getFailResult(500, "이메일 또는 비밀번호가 일치하지 않습니다.");
            }
        }

 */
        // 무조건 ROLE이 하나만 가진다고 가정
        return responseService.getSingleResult(jwtTokenUtil.generateToken(user.getUsername(), "ROLE_USER"));
    }
}
