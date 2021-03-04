package com.example.idus.api.controller;

import com.example.idus.api.dto.req.UserReqVO;
import com.example.idus.api.dto.res.UserInfoVO;
import com.example.idus.api.dto.res.OrderResVO;
import com.example.idus.api.dto.OrderDTO;
import com.example.idus.api.service.UserService;
import com.example.idus.config.response.ResponseException;
import com.example.idus.config.response.service.ResponseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Api(tags={"2. 사용자 조회"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseService responseService;

//    @ApiImplicitParams({
//            @ApiImplicitParam(name="AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
//   })
    @ApiOperation(value="단일 회원 상세 정보 조회", notes="회원 이름과 이메일로 회원 상세 정보를 조회")
    @GetMapping ("/getCustomerInfo")
    public ResponseEntity<?> test(@ApiParam(value="회원 이메일") @RequestParam(value="email", required = true) String email) throws ResponseException{
        // SecurityContext에서 인증받은 회원의 정보
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String id= authentication.getName();
        UserInfoVO user = userService.getCustomerInfo(new UserReqVO(email));
        return ResponseEntity.ok(user);
    }

    @ApiOperation(value="단일 회원 주문 목록 조회")
    @GetMapping ("/getOrderInfo")
    public ResponseEntity<?> getOrderInfo(@ApiParam(value="회원 이메일") @RequestParam(value="email", required = true) String email) throws ResponseException{
        List<OrderDTO> orderList = userService.getOrderInfo(new UserReqVO(email));
        OrderResVO res = new OrderResVO();
        res.UserResVO(orderList);
        res.setPerPageNum(orderList.size());
        return ResponseEntity.ok(res);
    }

    @ApiOperation(value="여러 회원 목록 조회")
    @GetMapping ("/getOrderList")
    public ResponseEntity<?> getOrderList(@ApiParam(value="회원 이름") @RequestParam(value="name", defaultValue = "", required = false) String name,
                                      @ApiParam(value="회원 이메일") @RequestParam(value="email", defaultValue = "") String email,
                                      @ApiParam(value="페이지 당 개수") @RequestParam(value="perPageNum", defaultValue = "10") int perPageNum) throws ResponseException{
        UserReqVO vo = new UserReqVO();
        vo.setPerPageNum(perPageNum);
        vo.setEmail(email);
        vo.setName(name);

        List<OrderDTO> orderList = userService.getOrderList(vo);
        OrderResVO res = new OrderResVO();
        res.UserResVO(orderList);
        res.setPerPageNum(perPageNum);
        return ResponseEntity.ok(res);
    }

}
