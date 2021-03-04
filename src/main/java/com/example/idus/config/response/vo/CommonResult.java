package com.example.idus.config.response.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommonResult {

    @ApiModelProperty(value = "응답 성공여부 : true/false")
    private boolean success;

    @ApiModelProperty(value = "응답 코드 번호")
    private int status;

    @ApiModelProperty(value = "응답 메시지")
    private String message;

    @ApiModelProperty(value = "응답 시간")
    private Date timesStamp;

}
