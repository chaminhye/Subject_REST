package com.example.idus.config.util;

import com.example.idus.api.dto.req.AuthReqVO;
import com.example.idus.config.response.ResponseException;
import com.example.idus.config.response.service.ResponseService;
import com.example.idus.config.type.ValidateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.regex.Pattern;

public class ValidateUtil {
    @Autowired
    private ResponseService responseService;


    // 이름 정규식 (한글, 영문 대소문자만 허용)
    public static final String regExp_name = "^[ㄱ-ㅎ가-힣a-zA-Z]{1,20}$";
    // 별명 정규식 (영어 소문자만 허용)
    public static final String regExp_nickName = "^[a-z]{1,30}$";
    // 패스워드 정규식 (영문 대문자, 영문 소문자, 특수 문자, 숫자 각 1개 이상씩 포함)
    public static final String regExp_password = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{10,}$";
    // 전화번호 정규식 (숫자)
    public static final String regExp_phone = "^[0-9]{11,12}$";
    // 이메일 정규식 (이메일 형식)
    public static final String regExp_email = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    /**
     *  회원가입 정규식 유효성 체크
     * @param plainText
     * @return boolean
     */
    public static ValidateType validate(AuthReqVO reqVO){
        // 이름 유효성 검사
        String name = Optional.ofNullable(reqVO.getName()).orElseThrow(() -> new ResponseException(AuthReqVO.class, "유효성 오류", ValidateType.NAME_ERROR.getValue()));
        if(!Pattern.matches(regExp_name,reqVO.getName())){
            return ValidateType.NAME_ERROR;
        }

        // 별명 유효성 검사
        String nickName = Optional.ofNullable(reqVO.getNickName()).orElseThrow(() -> new ResponseException(AuthReqVO.class, "유효성 오류", ValidateType.NICKNAME_ERROR.getValue()));
        if(!Pattern.matches(regExp_nickName, nickName)){
            return ValidateType.NICKNAME_ERROR;
        }
        // 패스워드 유효성 검사
        String pwd = Optional.ofNullable(reqVO.getPassword()).orElseThrow(() -> new ResponseException(AuthReqVO.class, "유효성 오류", ValidateType.PWD_ERROR.getValue()));
        if(!Pattern.matches(regExp_password, pwd)){
            return ValidateType.PWD_ERROR;
        }
        // 전화번호 유효성 검사
        String phone = Optional.ofNullable(reqVO.getPhoneNumber()).orElseThrow(() -> new ResponseException(AuthReqVO.class, "유효성 오류", ValidateType.PHONE_ERROR.getValue()));
        if(!Pattern.matches(regExp_phone, phone)){
            return ValidateType.PHONE_ERROR;
        }
        // 이메일 유효성 검사
        String email = Optional.ofNullable(reqVO.getEmail()).orElseThrow(() -> new ResponseException(AuthReqVO.class, "유효성 오류", ValidateType.EMAIL_ERROR.getValue()));
        if(!Pattern.matches(regExp_email, email)){
            return ValidateType.EMAIL_ERROR;
        }

        return ValidateType.ALL_PASS;
    }
}