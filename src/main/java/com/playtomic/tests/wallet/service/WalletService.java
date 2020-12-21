package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.RechargeRequest;
import com.playtomic.tests.wallet.dao.WalletResponse;
import com.playtomic.tests.wallet.domain.Wallet;

public interface WalletService {
    void charge(ChargeRequest request);
    void recharge(RechargeRequest request);
    WalletResponse getWallet(String id);
}
