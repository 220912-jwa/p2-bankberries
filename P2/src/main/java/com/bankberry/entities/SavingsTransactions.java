package com.bankberry.entities;

public class SavingsTransactions {
    private int savingsTransId;
    private String savingsTransDescription;
    private double savingsTransAmount;

    private int savingsAccountId;

    private SavingsAccount savingsAccount;

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public int getSavingsAccountId() {
        return savingsAccountId;
    }

    public SavingsTransactions(String savingsTransDescription, double savingsTransAmount, int savingsAccountId) {
        this.savingsTransDescription = savingsTransDescription;
        this.savingsTransAmount = savingsTransAmount;
        this.savingsAccountId = savingsAccountId;
    }

    public void setSavingsAccountId(int savingsAccountId) {
        this.savingsAccountId = savingsAccountId;
    }

    public SavingsTransactions() {
    }

    public SavingsTransactions(int savingsTransId, String savingsTransDescription, double savingsTransAmount, int savingsAccountId, SavingsAccount savingsAccount) {
        this.savingsTransId = savingsTransId;
        this.savingsTransDescription = savingsTransDescription;
        this.savingsTransAmount = savingsTransAmount;
        this.savingsAccountId = savingsAccountId;
        this.savingsAccount = savingsAccount;
    }

    public int getSavingsTransId() {
        return savingsTransId;
    }

    public void setSavingsTransId(int savingsTransId) {
        this.savingsTransId = savingsTransId;
    }

    public String getSavingsTransDescription() {
        return savingsTransDescription;
    }

    public void setSavingsTransDescription(String savingsTransDescription) {
        this.savingsTransDescription = savingsTransDescription;
    }

    public double getSavingsTransAmount() {
        return savingsTransAmount;
    }

    public void setSavingsTransAmount(double savingsTransAmount) {
        this.savingsTransAmount = savingsTransAmount;
    }


    @Override
    public String toString() {
        return "SavingsTransactions{" +
                "savingsTransId=" + savingsTransId +
                ", savingsTransDescription='" + savingsTransDescription + '\'' +
                ", savingsTransAmount=" + savingsTransAmount +
                ", savingsAccountId=" + savingsAccountId +
                '}';
    }
}
