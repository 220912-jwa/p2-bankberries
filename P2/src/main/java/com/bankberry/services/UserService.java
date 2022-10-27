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
    private UserDAO userDAO;

    public UserService(CheckingTransactionsDAO checkingTransactionsDAO, SavingsTransactionDAO savingsTransactionDAO,
                       CheckingAccountDAO checkingAccountDAO, SavingsAccountDAO savingsAccountDAO,
                       LoanAppDAO loanAppDAO, UserDAO userDAO) {
        this.checkingTransactionsDAO = checkingTransactionsDAO;
        this.savingsTransactionDAO = savingsTransactionDAO;
        this.checkingAccountDAO = checkingAccountDAO;
        this.savingsAccountDAO = savingsAccountDAO;
        this.loanAppDAO = loanAppDAO;
        this.userDAO = userDAO;
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
    public List<CheckingTransactions> getByCheckingTransactionId(int id){
        //use the id for the checking account that is referenced by the foreign key
        return checkingTransactionsDAO.getById(id);
    }

    public void updateChecking(int id, double amount){
        checkingAccountDAO.updateChecking(id,amount);

    }
    public void updateSavings(int id, double amount){
        savingsAccountDAO.updateSavings(id, amount);
    }


    public CheckingTransactions createCheckingTransactions(CheckingTransactions checkingTransactions){

        return checkingTransactionsDAO.createTransaction(checkingTransactions);
    }
    public SavingsTransactions createSavingsTransactions(SavingsTransactions savingsTransactions){
        return savingsTransactionDAO.createTransaction(savingsTransactions);
    }

    public LoanApplication createLoanApp(LoanApplication loanApplication){
        return loanAppDAO.createLoan(loanApplication);
    }

    public void updateEmail(String email, int accessNumber){
        userDAO.updateEmail(email, accessNumber);

    }
    public void updatePassword(String password, int accessNumber){
        userDAO.updatePass(password,accessNumber);
    }
}
