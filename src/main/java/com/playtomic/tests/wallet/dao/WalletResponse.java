package com.playtomic.tests.wallet.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class WalletResponse {
    private String uuid;
    private BigDecimal balance;
}
