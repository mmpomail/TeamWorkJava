package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void addSumLowerThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void addSumMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(11_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void addNegativeValue() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-50);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payByNegativeValue() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-100);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void paySumBiggerThanInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payAvailableSum() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void ifBalanceAfterPayLowerThanMin() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_500);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void testIfRateIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(2_000, 1_000, 10_000, -1));
    }

    @Test
    public void testIfNegativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(2_000, -1_000, 10_000, 5));
    }

    @Test
    public void testIfMaxBalanceLowerThanMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(500, 5_000, 1_000, 5));
    }

    @Test
    public void testIfInitBalanceLowerThanMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(500, 1_000, 5_000, 5));
    }


    @Test
    public void testForYearChange() {
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                10
        );

        Assertions.assertEquals(500, account.yearChange());
    }

    @Test
    public void testForYearChangeWhenRate0() {
        SavingAccount account = new SavingAccount(
                5_000,
                500,
                20_000,
                0
        );

        Assertions.assertEquals(0, account.yearChange());
    }

}


