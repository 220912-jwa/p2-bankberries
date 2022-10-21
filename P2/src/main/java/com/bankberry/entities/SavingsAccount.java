package com.bankberry.entities;

public class SavingsAccount {
    private int savingsAccountNumber;
    private double savingsBalance;


    public SavingsAccount(int savingsAccountNumber, double savingsBalance) {
        this.savingsAccountNumber = savingsAccountNumber;
        this.savingsBalance = savingsBalance;

    }

    public SavingsAccount() {
    }

    public int getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    public void setSavingsAccountNumber(int savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }



    @Override
    public String toString() {
        return "SavingsAccount{" +
                "savingsAccountNumber=" + savingsAccountNumber +
                ", savingsBalance=" + savingsBalance +

                '}';
    }
}
