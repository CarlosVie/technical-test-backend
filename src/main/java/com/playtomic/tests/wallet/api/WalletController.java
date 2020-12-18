package com.playtomic.tests.wallet.api;

import com.playtomic.tests.wallet.dao.ChargeRequest;
import com.playtomic.tests.wallet.dao.PaymentRequest;
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

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/wallet")
public class WalletController {
    private Logger log = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private WalletService service;


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletResponse> walletById(@PathVariable String id) {
        log.info("Search wallet with id {}", id);
        service.getWalletById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(path = "/payment",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity payment(@RequestBody PaymentRequest request) {
        service.payment(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(path = "/charge",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity charge(@RequestBody ChargeRequest request) {
        service.charge(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
