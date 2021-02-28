package com.example.idus.api.dto.req;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserReqVO {
    private String name;        // 회원 이름
    private String email;       // 회원 이메일
    private int perPageNum;     // 페이지네이션

    public UserReqVO(String name, String email, int perPageNum){
        this.name = name;
        this.email = email;
        this.perPageNum = perPageNum;
    }
}
