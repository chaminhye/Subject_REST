package com.example.idus.api.service;

import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.dto.req.AuthReqVO;
import com.example.idus.api.mapper.AuthMapper;
import com.example.idus.config.response.ResponseException;
import com.example.idus.config.response.service.ResponseService;
import com.example.idus.config.type.ValidateType;
import com.example.idus.config.util.ValidateUtil;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AuthMapper authMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ResponseService responseService;

    @Override
    public UserDetails loadUserByUsername(String username){
        return authMapper.selectByUserName(username);
    }

    public UserDTO getUserInfo(AuthReqVO reqVO){
        UserDTO user = authMapper.selectByEmail(reqVO);
        if(user == null){
            throw new ResponseException(AuthReqVO.class, "일치하는 계정이 존재하지 않습니다.", "not exist customer");
        }
        return user;
    }

    public int saveUser(AuthReqVO reqVO) {
        // 유효성 체크
        ValidateType resultCode = ValidateUtil.validate(reqVO);
        if(ValidateType.ALL_PASS != resultCode){
            throw new ResponseException(AuthReqVO.class, "유효성 오류", resultCode.toString());
        }
        // 비밀번호 암호화
        reqVO.setPassword(passwordEncoder.encode(reqVO.getPassword()));
        return authMapper.insertUser(reqVO);
    }

}
