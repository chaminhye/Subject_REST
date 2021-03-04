package com.example.idus.api.dto;

import com.example.idus.config.common.Paging;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OrderDTO{
    private String orderIdx;                // 주문번호
    private String orderCustomerIdx;        // 주문번호
    private String productName;             // 주문명
    private String orderDate;               // 주문일자
    private String orderName;               // 주문자 이름
}
