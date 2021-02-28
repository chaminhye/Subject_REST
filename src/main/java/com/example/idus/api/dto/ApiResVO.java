package com.example.idus.api.dto;

import com.example.idus.config.common.Paging;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiResVO extends Paging {
    private List<OrderVO> orderList;

    public void ApiResVO(List<OrderVO> list){
        this.orderList = list;
    }
}
