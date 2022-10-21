package com.bankberry.entities;

public class CheckingAccount {
    private int accountNumber;
    private double balance;


    public CheckingAccount() {
    }

    public CheckingAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;

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


    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +

                '}';
    }
}
