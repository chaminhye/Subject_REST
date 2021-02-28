package com.example.idus.api.service;

import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.mapper.AuthMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String username){
        return authMapper.selectByUserName(username);
    }

    public UserDTO getUserInfo(String username){
        return authMapper.selectByEmail(username);
    }

}
