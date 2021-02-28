package com.example.idus.api.mapper;

import com.example.idus.api.dto.ApiReqVO;
import com.example.idus.api.dto.OrderVO;
import com.example.idus.api.dto.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserVO selectCustomerInfo(ApiReqVO req);
    List<OrderVO> selectOrderList(ApiReqVO req);
}
