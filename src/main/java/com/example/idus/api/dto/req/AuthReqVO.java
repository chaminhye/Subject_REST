package com.example.idus.api.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthReqVO {
    private String name;        // 회원 이름
    private String nickName;       // 회원 별명
    private String phoneNumber; // 회원 전화번호
    private String password;    // 회원 비밀번호
    private String email;       // 회원 이메일
    private String gender;      // 회원 성별
}
