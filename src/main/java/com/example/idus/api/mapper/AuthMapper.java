package com.example.idus.api.mapper;

import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.dto.req.AuthReqVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface AuthMapper {
    UserDetails selectByUserName(String username);
    UserDTO selectByEmail(AuthReqVO vo);
    int insertUser(AuthReqVO vo);
}
