package com.playtomic.tests.wallet.dao;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletResponse {
    private String uuid;
    private BigDecimal balance;
}
