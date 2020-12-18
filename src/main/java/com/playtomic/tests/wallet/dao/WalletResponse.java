package com.playtomic.tests.wallet.dao;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class WalletResponse {
    private String uuid;
    private BigDecimal balance;
}
