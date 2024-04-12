package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-1);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldNotAddToNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(0, 5000,-15);
        });
    }

    @Test
    public void shouldNotAddToNegativeInitBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-5001, 5000,15);
        });
    }

    @Test
    public void shouldNotAddToNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(5000, -5000,15);
        });
    }

    @Test
    public void shouldNotPayToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(-1);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayToLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(5000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }

    @Test
    public void shouldPayAroundLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(4999);

        Assertions.assertEquals(-4_999, account.getBalance());
    }

    @Test
    public void shouldNotPayAboveLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(5_001);

        Assertions.assertEquals(0, account.getBalance());
    }

}
