package com.example.idus.api.dto.req;

import com.example.idus.config.common.Paging;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserReqVO extends Paging {
    private String name;        // 회원 이름
    private String email;       // 회원 이메일

    public UserReqVO(String email){
        this.email = email;
    }
}
