package com.example.idus.api.dto.res;

import com.example.idus.api.dto.OrderDTO;
import com.example.idus.config.common.Paging;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderResVO extends Paging {
    private List<OrderDTO> orderList;

    public void UserResVO(List<OrderDTO> list){
        this.orderList = list;
    }
}
