package com.bankberry.entities;

public class CheckingTransactions {
    private int ckingTransId;
    private String transDescription;
    private double ckTransAmount;
    private int checkingAccountId;

    public int getCheckingAccountId() {
        return checkingAccountId;
    }

    public void setCheckingAccountId(int checkingAccountId) {
        this.checkingAccountId = checkingAccountId;
    }

    public CheckingTransactions() {
    }

    public CheckingTransactions(int ckingTransId, String transDescription, double ckTransAmount, int checkingAccountId) {
        this.ckingTransId = ckingTransId;
        this.transDescription = transDescription;
        this.ckTransAmount = ckTransAmount;
        this.checkingAccountId = checkingAccountId;
    }

    public int getCkingTransId() {
        return ckingTransId;
    }

    public void setCkingTransId(int ckingTransId) {
        this.ckingTransId = ckingTransId;
    }

    public String getTransDescription() {
        return transDescription;
    }

    public void setTransDescription(String transDescription) {
        this.transDescription = transDescription;
    }

    public double getCkTransAmount() {
        return ckTransAmount;
    }

    public void setCkTransAmount(double ckTransAmount) {
        this.ckTransAmount = ckTransAmount;
    }

    @Override
    public String toString() {
        return "CheckingTransactions{" +
                "ckingTransId=" + ckingTransId +
                ", transDescription='" + transDescription + '\'' +
                ", ckTransAmount=" + ckTransAmount +
                ", checkingAccountId=" + checkingAccountId +
                '}';
    }
}
