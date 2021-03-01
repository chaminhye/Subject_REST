package com.example.idus.api.service;

import com.example.idus.api.dto.req.UserReqVO;
import com.example.idus.api.dto.OrderDTO;
import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.mapper.UserMapper;
import com.example.idus.config.response.ResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserDTO getCustomerInfo(UserReqVO req){
        UserDTO res = userMapper.selectCustomerInfo(req);
        if(res == null){
            throw new ResponseException(UserReqVO.class, "검색결과", "0건");
        }
        return res;
    }

    public List<OrderDTO> getOrderList(UserReqVO req){
        List<OrderDTO> list = userMapper.selectOrderList(req);
        if(list == null){
            throw new ResponseException(UserReqVO.class, "검색결과", "0건");
        }
        return list;
    }
}
