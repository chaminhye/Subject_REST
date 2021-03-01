package com.example.idus.config.util;

import com.example.idus.api.dto.req.AuthReqVO;
import com.example.idus.config.type.ValidateType;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class ValidateUtil {

    // 이름 정규식 (한글, 영문 대소문자만 허용)
    public static final String regExp_name = "^[ㄱ-ㅎ가-힣]|[a-zA-Z]{1,20}$";
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
    public static String validate(AuthReqVO reqVO){
        // 이름 유효성 검사
        String name = StringUtils.hasLength(reqVO.getName()) ? reqVO.getName() : ValidateType.NAME_ERROR.getValue();
        if(!Pattern.matches(regExp_name,name)){
            return ValidateType.NAME_ERROR.getValue();
        }

        // 별명 유효성 검사
        String nickName = StringUtils.hasLength(reqVO.getNickName()) ? reqVO.getNickName() : ValidateType.NICKNAME_ERROR.getValue() ;
        if(!Pattern.matches(regExp_nickName, nickName)){
            return ValidateType.NICKNAME_ERROR.getValue();
        }
        // 패스워드 유효성 검사
        String pwd = StringUtils.hasLength(reqVO.getPassword()) ? reqVO.getPassword() : ValidateType.PWD_ERROR.getValue();
        if(!Pattern.matches(regExp_password, pwd)){
            return ValidateType.PWD_ERROR.getValue();
        }
        // 이름 유효성 검사
        String phone = StringUtils.hasLength(reqVO.getPhoneNumber()) ? reqVO.getPhoneNumber() : ValidateType.PHONE_ERROR.getValue();
        if(!Pattern.matches(regExp_phone, phone)){
            return ValidateType.PHONE_ERROR.getValue();
        }
        // 이름 유효성 검사
        String email = StringUtils.hasLength(reqVO.getEmail()) ? reqVO.getEmail() : ValidateType.EMAIL_ERROR.getValue();
        if(!Pattern.matches(regExp_email, email)){
            return ValidateType.EMAIL_ERROR.getValue();
        }

        return ValidateType.ALL_PASS.getValue();
    }
}