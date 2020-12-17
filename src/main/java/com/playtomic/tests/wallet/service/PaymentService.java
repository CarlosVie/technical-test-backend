package com.playtomic.tests.wallet.service;

import java.math.BigDecimal;

@FunctionalInterface
public interface PaymentService {
    void pay(BigDecimal request);
}
