package com.playtomic.tests.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
public class Wallet {
    private String uuid;
    private BigDecimal balance;
}
