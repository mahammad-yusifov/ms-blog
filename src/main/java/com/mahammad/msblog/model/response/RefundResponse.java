package com.mahammad.msblog.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundResponse {

    private Integer customerId;
    private BigDecimal balance;
}
