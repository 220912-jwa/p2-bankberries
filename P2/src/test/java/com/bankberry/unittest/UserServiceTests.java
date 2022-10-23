package com.bankberry.unittest;


import com.bankberry.DAOS.*;
import com.bankberry.entities.*;
import com.bankberry.services.AuthenticationService;
import com.bankberry.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


    /*
    -updateChecking
    -updateCheckingTransaction
    -updateSaving
    -updateSavingTransaction
    -checkingBalances
    -checkCheckingTransactions
    -savingBalances
    -checkSavingTransaction
    -loginCheck
    -fundsTransferChecking
    -fundsTransferSaving
    -submitLoanAppCheck
    -emailChange
    -passChange
    -checkPendingLoan
     */

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @InjectMocks
    private static UserService mockUserService;

    @Mock
    private static UserDAO mockUserDAO;

    @Mock
    private static SavingsAccountDAO mockSavingsAccountDAO;

    @Mock
    private static SavingsTransactionDAO mockSavingsTransactionDAO;

    @Mock
    private static LoanAppDAO mockLoanAppDAO;

    @Mock
    private static CheckingTransactionsDAO mockCheckingTransactionsDAO;

    @Mock
    private static CheckingAccountDAO mockCheckingAccountDAO;

    @Mock
    private List<LoanApplication> mockLoanApplicationList;

    @Mock
    private SavingsTransactions mockSavingsTransactions;

    @Mock
    private SavingsAccount mockSavingsAccount;

    @Mock
    private LoanApplication mockLoanApplication;

    @Mock
    private CheckingTransactions mockCheckingTransactions;

    @Mock
    private CheckingAccount mockCheckingAccount;

    @Mock
    private User mockUser;


    @BeforeAll
    public static void setup() {
        mockUserDAO = new UserDAO();
        mockCheckingAccountDAO = new CheckingAccountDAO();
        mockCheckingTransactionsDAO = new CheckingTransactionsDAO();
        mockLoanAppDAO = new LoanAppDAO();
        mockSavingsAccountDAO = new SavingsAccountDAO();
        mockSavingsTransactionDAO = new SavingsTransactionDAO();
        mockUserService = new UserService(mockCheckingTransactionsDAO,mockSavingsTransactionDAO,mockCheckingAccountDAO,mockSavingsAccountDAO,mockLoanAppDAO);
    }

    @BeforeEach
    public void mockData() {
        mockLoanApplicationList = new ArrayList<>(Arrays.asList(mockLoanApplication));

        mockCheckingAccount = new CheckingAccount(
                1,
                1000
        );

        mockSavingsAccount = new SavingsAccount(
                1,
                1000
        );

        mockCheckingTransactions = new CheckingTransactions(
                1,
                "description",
                100,
                1
        );

        mockSavingsTransactions = new SavingsTransactions(
                1,
                "description",
                150,
                1
        );

        mockLoanApplication = new LoanApplication(
                5,
                3000,
                12,
                1
        );

    }

    @Test
    public void get_Id_Of_Checking_Account() {
        when(mockUserService.getById(mockCheckingAccount.getAccountNumber())).thenReturn(mockCheckingAccount);
        CheckingAccount nca = mockUserService.getById(mockCheckingAccount.getAccountNumber());
        Assertions.assertNotNull(nca);
    }

    @Test
    public void get_Id_Of_Savings_Account() {
        when(mockUserService.getBySavingsId(mockSavingsAccount.getSavingsAccountNumber())).thenReturn(mockSavingsAccount);
        SavingsAccount nsa = mockUserService.getBySavingsId(mockSavingsAccount.getSavingsAccountNumber());
        Assertions.assertNotNull(nsa);

    }

    @Test
    public void get_Loan_App_Id() {
        when(mockUserService.getByAppId(mockLoanApplication.getLoanAppId())).thenReturn(mockLoanApplicationList);
        List<LoanApplication> loanApp = mockUserService.getByAppId(mockLoanApplication.getLoanAppId());
        Assertions.assertNotNull(loanApp);
    }

    @Test
    public void get_Savings_Transaction_Id() {
        when(mockUserService.getBySavingsTransactionID(mockSavingsTransactions.getSavingsTransId())).thenReturn(mockSavingsTransactions);
        SavingsTransactions nst = mockUserService.getBySavingsTransactionID(mockSavingsTransactions.getSavingsTransId());
        Assertions.assertNotNull(nst);
    }

    @Test
    public void get_Checking_Transaction_Id() {
        when(mockUserService.getByCheckingTransactionId(mockCheckingTransactions.getCheckingAccountId())).thenReturn(mockCheckingTransactions);
        CheckingTransactions nct = mockUserService.getByCheckingTransactionId(mockCheckingTransactions.getCheckingAccountId());
        Assertions.assertNotNull(nct);
    }

    @Test
    public void update_Checking() {
        mockUserService.updateChecking(mockCheckingAccount.getAccountNumber(),mockCheckingTransactions.getCkTransAmount());
        verify(mockCheckingAccountDAO,times(1)).updateChecking(mockCheckingAccount.getAccountNumber(),mockCheckingTransactions.getCkTransAmount());

    }

    @Test
    public void update_Saving() {
        mockUserService.updateSavings(mockSavingsAccount.getSavingsAccountNumber(),mockSavingsTransactions.getSavingsTransAmount());
        verify(mockSavingsAccountDAO,times(1)).updateSavings(mockSavingsAccount.getSavingsAccountNumber(),mockSavingsTransactions.getSavingsTransAmount());
    }


}




