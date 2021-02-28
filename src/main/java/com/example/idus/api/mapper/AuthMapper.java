package com.example.idus.api.mapper;

import com.example.idus.api.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface AuthMapper {
    UserDetails selectByUserName(String username);
    UserDTO selectByEmail(String username);
}
