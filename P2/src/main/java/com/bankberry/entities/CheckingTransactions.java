package com.bankberry.entities;

public class CheckingTransactions {
    private int ckingTransId;
    private String transDescription;
    private double ckTransAmount;

    public CheckingTransactions() {
    }

    public CheckingTransactions(int ckingTransId, String transDescription, double ckTransAmount) {
        this.ckingTransId = ckingTransId;
        this.transDescription = transDescription;
        this.ckTransAmount = ckTransAmount;
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
                '}';
    }
}
