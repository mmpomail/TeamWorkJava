package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(-1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void balanceShouldNotChange() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }



    @Test
    public void shouldNotAddToNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(0, 5000, -15);
        });
    }

    @Test
    public void shouldNotAddToNegativeInitBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-5001, 5000, 15);
        });
    }

    @Test
    public void shouldNotAddToNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(5000, -5000, 15);
        });
    }

    @Test
    public void shouldPayBalanceInLimits() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(999);

        Assertions.assertEquals(1, account.getBalance());
    }

    @Test
    public void nothingToPay() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldNotPayIfAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(-2_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayIfAmountEqualsBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(1_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayInsideLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(4999);

        Assertions.assertEquals(-3_999, account.getBalance());
    }

    @Test
    public void shouldPayIncludeAllLimits() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }


    @Test
    public void shouldNotPayOverCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(6_001);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(5_000);

        Assertions.assertEquals(-4000, account.getBalance());
    }


    @Test
    public void yearChangeIfNegativeBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(5_000);

        Assertions.assertEquals(-600, account.yearChange());
    }

    @Test
    public void yearChangeIfPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(500);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeIfNullBalance() {
        CreditAccount account = new CreditAccount(
                3000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(0, account.yearChange());
    }

}
