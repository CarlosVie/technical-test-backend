package com.playtomic.tests.wallet.service.impl;


import com.playtomic.tests.wallet.exception.BadRequestException;
import org.junit.Test;

import java.math.BigDecimal;


public class ThirdPartyChargeServiceTest {
    ThirdPartyChargeServiceImpl s = new ThirdPartyChargeServiceImpl();

    @Test(expected = BadRequestException.class)
    public void test_exception() throws BadRequestException {
        s.charge(new BigDecimal(5));
    }

    @Test
    public void test_ok() throws BadRequestException {
        s.charge(new BigDecimal(15));
    }
}
