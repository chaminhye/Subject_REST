package com.example.idus.config.util;

import com.example.idus.api.dto.req.AuthReqVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(controllers = ValidateUtil.class)
class ValidateUtilTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void validate() {
        AuthReqVO vo = new AuthReqVO();
        vo.setName("한글이름g");
        vo.setPassword("adfd2314");
        vo.setNickName("aliasg");
        vo.setEmail("한글이름g_dfsf.cv");

        mvc.perform(post("/api/auth/signup"))
                .andExpect(status().isOk())
                .andExpect(content(vo))
    }
}