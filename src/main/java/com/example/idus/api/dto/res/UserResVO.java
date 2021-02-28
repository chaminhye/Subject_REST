package com.example.idus.api.dto.res;

import com.example.idus.api.dto.OrderDTO;
import com.example.idus.config.common.Paging;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserResVO extends Paging {
    private List<OrderDTO> orderList;

    public void ApiResVO(List<OrderDTO> list){
        this.orderList = list;
    }
}
