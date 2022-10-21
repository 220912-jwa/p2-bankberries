package com.bankberry.services;

import com.bankberry.DAOS.*;
import com.bankberry.entities.*;

import java.util.List;


public class UserService {

    private CheckingTransactionsDAO checkingTransactionsDAO;
    private SavingsTransactionDAO savingsTransactionDAO;
    private CheckingAccountDAO checkingAccountDAO;
    private SavingsAccountDAO savingsAccountDAO;
    private LoanAppDAO loanAppDAO;


    public UserService(CheckingTransactionsDAO checkingTransactionsDAO, SavingsTransactionDAO savingsTransactionDAO,
                       CheckingAccountDAO checkingAccountDAO, SavingsAccountDAO savingsAccountDAO, LoanAppDAO loanAppDAO) {
        this.checkingTransactionsDAO = checkingTransactionsDAO;
        this.savingsTransactionDAO = savingsTransactionDAO;
        this.checkingAccountDAO = checkingAccountDAO;
        this.savingsAccountDAO = savingsAccountDAO;
        this.loanAppDAO = loanAppDAO;
    }

    public CheckingAccount getById(int id){
        return checkingAccountDAO.getByAccountNumber(id);
    }
    public SavingsAccount getBySavingsId(int id){
        return savingsAccountDAO.getByAccountNumber(id);
    }
    public List<LoanApplication> getByAppId(int id){
        //foreign key id used here
        return loanAppDAO.getAllUserLoans(id);

    }
    public SavingsTransactions getBySavingsTransactionID(int id){
        //use the id for the savings account that is referenced by the foreign key
        return savingsTransactionDAO.getById(id);

    }
    public CheckingTransactions getByCheckingTransactionId(int id){
        //use the id for the checking account that is referenced by the foreign key
        return checkingTransactionsDAO.getById(id);
    }
}
