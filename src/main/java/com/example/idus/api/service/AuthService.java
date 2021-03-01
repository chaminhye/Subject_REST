package com.example.idus.api.service;

import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.dto.req.AuthReqVO;
import com.example.idus.api.mapper.AuthMapper;
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
        // 비밀번호 암호화
        reqVO.setPassword(passwordEncoder.encode(reqVO.getPassword()));
        return authMapper.insertUser(reqVO);
    }

}
