package com.playtomic.tests.wallet;

import com.playtomic.tests.wallet.dao.WalletResponse;
import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.BadRequestException;
import com.playtomic.tests.wallet.exception.DataNotFoundException;
import com.playtomic.tests.wallet.repository.WalletRepository;
import com.playtomic.tests.wallet.service.WalletService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.playtomic.tests.wallet.TestData.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class WalletApplicationIT {

	@Autowired
	private WalletRepository repository;

	@Autowired
	private WalletService walletService;

	@Before
	public void init() {
		repository.save(TEST_WALLET_ONE);
		repository.save(TEST_WALLET_TWO);
	}

	@Test
	public void getWalletTestSuccess() {
		WalletResponse response = walletService.getWallet(TEST_WALLET_ONE.getUuid());
		assertEquals(response, WALLET_RESPONSE);
	}

	@Test(expected = DataNotFoundException.class)
	public void getWalletTestFailed() {
		walletService.getWallet("fake_uuid");
	}

	@Test(expected = BadRequestException.class)
	public void chargeTestFailed() {
		walletService.charge(CHARGE_REQUEST);
	}

	@Test(expected = BadRequestException.class)
	public void chargeTestFailedBecauseAmount() {
		walletService.charge(CHARGE_REQUEST_TWO);
	}

	@Test
	public void rechargeFailed() {
		walletService.recharge(RECHARGE_REQUEST);
		Wallet wallet = repository.findOne(RECHARGE_REQUEST.getUuid());
		assertEquals(wallet, TEST_WALLET_THREE);
	}
}
