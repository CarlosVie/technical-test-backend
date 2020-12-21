package com.playtomic.tests.wallet.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RechargeRequest {
    @NotNull(message = "uuid can not be empty")
    private String uuid;
    @NotNull(message = "amount can not be empty")
    private BigDecimal amount;
}
