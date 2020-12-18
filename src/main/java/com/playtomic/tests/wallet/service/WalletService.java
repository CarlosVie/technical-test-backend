package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.PaymentRequest;
import com.playtomic.tests.wallet.dao.WalletResponse;

public interface WalletService {
    void charge(ChargeRequest request);
    void payment(PaymentRequest request);
    WalletResponse getWalletById(String id);
}
