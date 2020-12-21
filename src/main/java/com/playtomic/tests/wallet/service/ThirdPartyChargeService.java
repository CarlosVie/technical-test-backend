package com.playtomic.tests.wallet.service;

import java.math.BigDecimal;

@FunctionalInterface
public interface ThirdPartyChargeService {
    void charge(BigDecimal amount);
}
