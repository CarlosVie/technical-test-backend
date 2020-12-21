package com.playtomic.tests.wallet;

import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.RechargeRequest;
import com.playtomic.tests.wallet.dao.WalletResponse;
import com.playtomic.tests.wallet.domain.Wallet;

import java.math.BigDecimal;

public class TestData {
    public final static Wallet TEST_WALLET_ONE = new Wallet("123e4567-e89b-12d3-a456-556642440000",
            new BigDecimal(1));
    public final static WalletResponse WALLET_RESPONSE = new WalletResponse("123e4567-e89b-12d3-a456-556642440000",
            new BigDecimal("1.00"));
    public final static Wallet TEST_WALLET_TWO = new Wallet("123e4567-e89b-12d3-a456-556642445234",
            new BigDecimal(11));
    public final static Wallet TEST_WALLET_THREE = new Wallet("123e4567-e89b-12d3-a456-556642440000",
            new BigDecimal("2.00"));

    public final static ChargeRequest CHARGE_REQUEST = new ChargeRequest("123e4567-e89b-12d3-a456-556642445234", new BigDecimal(1));
    public final static ChargeRequest CHARGE_REQUEST_TWO = new ChargeRequest("123e4567-e89b-12d3-a456-556642445234", new BigDecimal(21));
    public final static RechargeRequest RECHARGE_REQUEST = new RechargeRequest("123e4567-e89b-12d3-a456-556642440000", new BigDecimal(1));
}
