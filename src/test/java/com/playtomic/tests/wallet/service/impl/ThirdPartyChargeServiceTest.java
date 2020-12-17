package com.playtomic.tests.wallet.service.impl;


import com.playtomic.tests.wallet.exception.PaymentServiceException;
import org.junit.Test;

import java.math.BigDecimal;

public class ThirdPartyChargeServiceTest {

    ThirdPartyChargeService s = new ThirdPartyChargeService();

    @Test(expected = PaymentServiceException.class)
    public void test_exception() throws PaymentServiceException {
        s.charge(new BigDecimal(5));
    }

    @Test
    public void test_ok() throws PaymentServiceException {
        s.charge(new BigDecimal(15));
    }
}
