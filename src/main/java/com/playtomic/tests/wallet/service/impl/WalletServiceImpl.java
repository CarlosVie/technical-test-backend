package com.playtomic.tests.wallet.service.impl;

import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.PaymentRequest;
import com.playtomic.tests.wallet.service.PaymentService;
import com.playtomic.tests.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ThirdPartyChargeService thirdPartyChargeService;

    @Override
    public void charge(ChargeRequest request) {
        //
    }

    @Override
    public void payment(PaymentRequest request) {

    }
}
