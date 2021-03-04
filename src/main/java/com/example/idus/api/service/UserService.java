package com.example.idus.api.service;

import com.example.idus.api.dto.req.UserReqVO;
import com.example.idus.api.dto.OrderDTO;
import com.example.idus.api.dto.UserDTO;
import com.example.idus.api.dto.res.UserInfoVO;
import com.example.idus.api.mapper.UserMapper;
import com.example.idus.config.response.ResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfoVO getCustomerInfo(UserReqVO req){
        UserInfoVO res = userMapper.selectCustomerInfo(req);
        return res;
    }

    public List<OrderDTO> getOrderInfo(UserReqVO req){
        List<OrderDTO> list = userMapper.selectOrder(req);
        return list;
    }

    public List<OrderDTO> getOrderList(UserReqVO req){
        List<OrderDTO> list = userMapper.selectOrderList(req);
        return list;
    }
}
