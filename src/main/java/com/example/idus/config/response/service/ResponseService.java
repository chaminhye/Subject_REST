package com.example.idus.config.response.service;

import com.example.idus.config.response.vo.CommonResult;
import com.example.idus.config.response.vo.ListResult;
import com.example.idus.config.response.vo.SingleResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResponseService {
    Date now = new Date();
/*
    // enum으로 api 요청 결과에 대한 code, message를 정의합니다.
    public enum CommonResponse {
        SUCCESS(200, "성공하였습니다."),
        FAIL(500, "실패하였습니다.");

        int status;
        String message;

        CommonResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

    }*/
    // 단일건 결과를 처리하는 메소드
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }
    // 다중건 결과를 처리하는 메소드
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }
    // 성공 결과만 처리하는 메소드
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }
    // 실패 결과만 처리하는 메소드
    public CommonResult getFailResult(int status, String msg) {
        CommonResult result = new CommonResult();
//        result.setSuccess(false);
        result.setStatus(status);
        result.setMessage(msg);
        result.setTimesStamp(now);
        return result;
    }
    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
    private void setSuccessResult(CommonResult result) {
//        result.setSuccess(true);
        result.setStatus(200);
        result.setMessage("성공하였습니다.");
        result.setTimesStamp(now);
    }

}
