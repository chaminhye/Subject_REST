package com.example.idus.config.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum ValidateType {
    NAME_ERROR("이름형식이 올바르지 않습니다."),
    NICKNAME_ERROR("별명형식이 올바르지 않습니다."),
    PWD_ERROR("패스워드형식이 올바르지 않습니다."),
    PHONE_ERROR("전화번호형식이 올바르지 않습니다."),
    EMAIL_ERROR("이메일형식이 올바르지 않습니다."),
    ALL_PASS("유효성통과");

    @Getter
    private String value;
    @Override
    public String toString(){
        return value;
    }

    private static final Map<String, ValidateType> valueMap;

    static {
        valueMap = new HashMap<>();
        for(ValidateType e : ValidateType.values()){
            valueMap.put(e.value, e);
        }
    }
    public static ValidateType fromValue(Object value){
        Assert.notNull(value, "fromValue는 null 값을 허용하지 않습니다.");
        return fromValue(value.toString());
    }
    public static ValidateType fromValue(String value){
        Assert.notNull(value, "fromValue는 null 값을 허용하지 않습니다.");
        return valueMap.get(value.trim());
    }
}
