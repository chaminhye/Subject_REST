package com.example.idus.api.service;

import com.example.idus.api.dto.ApiReqVO;
import com.example.idus.api.dto.OrderVO;
import com.example.idus.api.dto.UserVO;
import com.example.idus.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserVO getCustomerInfo(ApiReqVO req){
        UserVO res = userMapper.selectCustomerInfo(req);
        if(res == null){
            return null;
        }
        return res;
    }

    public List<OrderVO> getOrderList(ApiReqVO req){
        List<OrderVO> list = userMapper.selectOrderList(req);
        if(list == null){
            return null;
        }
        return list;
    }
}
