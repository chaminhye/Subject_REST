package com.example.idus.api.controller;

import com.example.idus.api.dto.ApiReqVO;
import com.example.idus.api.dto.UserVO;
import com.example.idus.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
@Api(tags={"1. 회원가입 및 로그인"})
public class AuthController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="회원가입")
    @PostMapping ("/signup")
    public String test(@RequestBody String ex){
        return "dfgsdf";
    }
}
