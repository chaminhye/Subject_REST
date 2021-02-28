package com.example.idus.api.controller;

import com.example.idus.api.dto.ApiReqVO;
import com.example.idus.api.dto.ApiResVO;
import com.example.idus.api.dto.OrderVO;
import com.example.idus.api.dto.UserVO;
import com.example.idus.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Api(tags={"2. 사용자 조회"})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="단일 회원 상세 정보 조회")
    @GetMapping ("/getCustomerInfo")
    public ResponseEntity<?> test(@ApiParam(value="회원 이름") @RequestParam(value="name") String name,
                                      @ApiParam(value="회원 이메일") @RequestParam(value="email") String email){
        UserVO res = userService.getCustomerInfo(new ApiReqVO(name, email, 1));
        return new ResponseEntity<UserVO>(res, HttpStatus.OK);
    }

    @ApiOperation(value="단일 회원 주문 목록 조회 , 여러 회원 목록 조회")
    @GetMapping ("/getOrderList")
    public ResponseEntity<?> test(@ApiParam(value="회원 이름") @RequestParam(value="name", defaultValue = "") String name,
                                      @ApiParam(value="회원 이메일") @RequestParam(value="email", defaultValue = "") String email,
                                      @ApiParam(value="페이지네이션") @RequestParam(value="perPageNum", defaultValue = "10") int perPageNum){
        List<OrderVO> orderList = userService.getOrderList(new ApiReqVO(name, email, perPageNum));
        ApiResVO res = new ApiResVO();
        res.ApiResVO(orderList);
        return ResponseEntity.ok(res);
    }

}
