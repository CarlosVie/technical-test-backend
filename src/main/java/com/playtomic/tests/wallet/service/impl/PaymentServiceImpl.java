package com.playtomic.tests.wallet.service.impl;

import com.playtomic.tests.wallet.repository.WalletRepository;
import com.playtomic.tests.wallet.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private WalletRepository walletRepository;

    @Override
    public void pay(BigDecimal request) {

    }
}
