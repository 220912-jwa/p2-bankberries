package com.bankberry.entities;

public class LoanApplication {
    private int loanAppId;
    private double loanAmount;
    private int termInMonths;
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public LoanApplication() {
    }

    public LoanApplication(int loanAppId, double loanAmount, int termInMonths, int user_id) {
        this.loanAppId = loanAppId;
        this.loanAmount = loanAmount;
        this.termInMonths = termInMonths;
        this.user_id = user_id;
    }

    public int getLoanAppId() {
        return loanAppId;
    }

    public void setLoanAppId(int loanAppId) {
        this.loanAppId = loanAppId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(int termInMonths) {
        this.termInMonths = termInMonths;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "loanAppId=" + loanAppId +
                ", loanAmount=" + loanAmount +
                ", termInMonths=" + termInMonths +
                ", user_id=" + user_id +
                '}';
    }
}
