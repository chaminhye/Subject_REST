package com.example.idus.api.mapper;

import com.example.idus.api.dto.OrderDTO;
import com.example.idus.api.dto.req.UserReqVO;
import com.example.idus.api.dto.res.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserInfoVO selectCustomerInfo(UserReqVO req);
    List<OrderDTO> selectOrder(UserReqVO req);
    List<OrderDTO> selectOrderList(UserReqVO req);
}
