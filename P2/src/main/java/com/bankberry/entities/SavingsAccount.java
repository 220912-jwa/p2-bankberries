package com.bankberry.entities;

public class SavingsAccount {
    private int savingsAccountNumber;
    private double savingsBalance;
    private int svngTransId;

    public SavingsAccount(int savingsAccountNumber, double savingsBalance, int svngTransId) {
        this.savingsAccountNumber = savingsAccountNumber;
        this.savingsBalance = savingsBalance;
        this.svngTransId = svngTransId;
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

    public int getSvngTransId() {
        return svngTransId;
    }

    public void setSvngTransId(int svngTransId) {
        this.svngTransId = svngTransId;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "savingsAccountNumber=" + savingsAccountNumber +
                ", savingsBalance=" + savingsBalance +
                ", svngTransId=" + svngTransId +
                '}';
    }
}
