package com.example.idus.api.service;

import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.dto.req.AuthReqVO;
import com.example.idus.api.mapper.AuthMapper;
import com.example.idus.config.response.ResponseException;
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

@RequiredArgsConstructor
@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AuthMapper authMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username){
        return authMapper.selectByUserName(username);
    }

    public UserDTO getUserInfo(AuthReqVO reqVO){
        return authMapper.selectByEmail(reqVO);
    }

    public int saveUser(AuthReqVO reqVO){
        // 유효성 체크

        String resultCode = ValidateUtil.validate(reqVO);
        if(!ValidateType.ALL_PASS.equals(resultCode)){
            throw new ResponseException(AuthReqVO.class, "유효성 오류", resultCode);
        }
        // 비밀번호 암호화
        reqVO.setPassword(passwordEncoder.encode(reqVO.getPassword()));
        return authMapper.insertUser(reqVO);
    }

}
