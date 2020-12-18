package com.playtomic.tests.wallet.service.impl;

import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.PaymentRequest;
import com.playtomic.tests.wallet.dao.WalletResponse;
import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.DataNotFoundException;
import com.playtomic.tests.wallet.repository.WalletRepository;
import com.playtomic.tests.wallet.service.PaymentService;
import com.playtomic.tests.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private WalletRepository repository;
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

    @Override
    public WalletResponse getWalletById(String id) {
        WalletResponse response;
        try {
            Wallet wallet = repository.findOne(id);
            response = WalletResponse.builder()
                    .uuid(wallet.getUuid())
                    .balance(wallet.getBalance()).build();
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(id);
        }
        return response;
    }
}
