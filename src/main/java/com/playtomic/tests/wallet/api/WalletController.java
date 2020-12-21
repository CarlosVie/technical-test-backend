package com.playtomic.tests.wallet.api;

import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.RechargeRequest;
import com.playtomic.tests.wallet.dao.WalletResponse;
import com.playtomic.tests.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * TODO add webSecurity, add swagger documentation
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/wallet")
public class WalletController {
    private Logger log = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private WalletService service;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletResponse> getWalletById(@PathVariable String id) {
        log.info("Search wallet with id {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getWallet(id));
    }

    @PostMapping(path = "/recharge",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity recharge(@Valid @RequestBody RechargeRequest request) {
        log.info("Start Payment transaction");
        service.recharge(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(path = "/charge",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity charge(@Valid @RequestBody ChargeRequest request) {
        log.info("Start charge transaction");
        service.charge(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
