package com.playtomic.tests.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
public class Wallet {
    @Id
    private String uuid;
    private BigDecimal balance;
}
