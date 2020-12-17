package com.playtomic.tests.wallet.dao;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ChargeRequest {
    @NotNull
    private String uuid;
    @NotNull
    private BigDecimal amount;
}
