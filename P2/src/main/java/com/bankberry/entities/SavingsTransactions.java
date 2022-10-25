package com.bankberry.entities;

public class SavingsTransactions {
    private int savingsTransId;
    private String savingsTransDescription;
    private double savingsTransAmount;

    private int savingsAccountId;

    public int getSavingsAccountId() {
        return savingsAccountId;
    }

    public void setSavingsAccountId(int savingsAccountId) {
        this.savingsAccountId = savingsAccountId;
    }

    public SavingsTransactions() {
    }

    public SavingsTransactions(int savingsTransId, String savingsTransDescription, double savingsTransAmount, int savingsAccountId) {
        this.savingsTransId = savingsTransId;
        this.savingsTransDescription = savingsTransDescription;
        this.savingsTransAmount = savingsTransAmount;
        this.savingsAccountId = savingsAccountId;
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
