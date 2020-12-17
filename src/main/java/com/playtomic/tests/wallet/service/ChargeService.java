package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.exception.PaymentServiceException;

import java.math.BigDecimal;

@FunctionalInterface
public interface ChargeService {
    void charge(BigDecimal amount) throws PaymentServiceException;
}
