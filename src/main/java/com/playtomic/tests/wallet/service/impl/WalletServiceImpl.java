package com.playtomic.tests.wallet.service.impl;

import com.playtomic.tests.wallet.api.WalletController;
import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.RechargeRequest;
import com.playtomic.tests.wallet.dao.WalletResponse;
import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.BadRequestException;
import com.playtomic.tests.wallet.exception.DataNotFoundException;
import com.playtomic.tests.wallet.repository.WalletRepository;
import com.playtomic.tests.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private Logger log = LoggerFactory.getLogger(WalletController.class);
    @Autowired
    private WalletRepository repository;
    @Autowired
    private ThirdPartyChargeServiceImpl thirdPartyChargeService;

    @Override
    public synchronized void charge(ChargeRequest request) {
        Wallet wallet = getWalletById(request.getUuid());
        if (wallet.getBalance().compareTo(request.getAmount()) >= 0) {
            thirdPartyChargeService.charge(request.getAmount());
            updateWalletSubtractBalance(wallet, request.getAmount());
        } else {
            log.error("Balance from wallet {} it's insufficient", request.getUuid());
            throw new BadRequestException("Balance it's insufficient");
        }
        log.info("Success process charge to {}", request.getUuid());
    }

    @Override
    public synchronized void recharge(RechargeRequest request) {
        Wallet wallet = getWalletById(request.getUuid());
        updateWalletAddBalance(wallet, request.getAmount());
        log.info("Success recharge balance.");
    }

    @Override
    public WalletResponse getWallet(String id) {
        Wallet wallet = getWalletById(id);
        return WalletResponse.builder()
                .uuid(wallet.getUuid())
                .balance(wallet.getBalance()).build();
    }

    private Wallet getWalletById(String id) {
        Wallet wallet = repository.findOne(id);
        if (wallet == null)
            throw new DataNotFoundException("Data not found with id " + id );
        return wallet;
    }

    private void updateWalletSubtractBalance(Wallet wallet, BigDecimal amount) {
        wallet.setBalance(wallet.getBalance().subtract(amount));
        Wallet updated = repository.save(wallet);
        if (updated == null) {
            // Compensation service
            log.error("Failed to subtract balance with id {}", wallet.getUuid());
            throw new BadRequestException("Failed to subtract balance with id " +  wallet.getUuid());
        }
    }

    private void updateWalletAddBalance(Wallet wallet, BigDecimal amount) {
        wallet.setBalance(wallet.getBalance().add(amount));
        Wallet updated = repository.save(wallet);
        if (updated == null) {
            // Compensation service
            log.error("Failed add to balance with id {}", wallet.getUuid());
            throw new BadRequestException("Failed add to balance with id " +  wallet.getUuid());
        }
    }
}
