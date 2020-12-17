package com.playtomic.tests.wallet.api;

import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.PaymentRequest;
import com.playtomic.tests.wallet.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/wallet",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class WalletController {
    private Logger log = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private PaymentService paymentService;

    @GetMapping(path = "/{id}")
    public void walletById(@PathVariable String id) {
        return;
    }

    @PostMapping(path = "/{id}")
    public void payment(@RequestBody PaymentRequest request) {
        return;
    }

    @PostMapping(path = "/{id}/charge")
    public void charge(@RequestBody ChargeRequest request) {
        return;
    }
}
