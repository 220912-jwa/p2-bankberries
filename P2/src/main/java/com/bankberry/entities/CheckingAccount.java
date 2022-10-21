package com.bankberry.entities;

public class CheckingAccount {
    private int accountNumber;
    private double balance;
    private int ckTransId;

    public CheckingAccount() {
    }

    public CheckingAccount(int accountNumber, double balance, int ckTransId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ckTransId = ckTransId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCkTransId() {
        return ckTransId;
    }

    public void setCkTransId(int ckTransId) {
        this.ckTransId = ckTransId;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", ckTransId=" + ckTransId +
                '}';
    }
}
