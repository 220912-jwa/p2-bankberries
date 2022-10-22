package com.bankberry;

import com.bankberry.DAOS.*;
import com.bankberry.controllers.AuthenticationController;
import com.bankberry.controllers.UserController;
import com.bankberry.services.AuthenticationService;
import com.bankberry.services.UserService;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class AppRunner {
    public static void main(String[] args) {

        UserDAO userDAO= new UserDAO();
        LoanAppDAO loanAppDAO = new LoanAppDAO();
        CheckingAccountDAO checkingAccountDAO =new CheckingAccountDAO();
        SavingsAccountDAO savingsAccountDAO = new SavingsAccountDAO();
        CheckingTransactionsDAO checkingTransactionsDAO = new CheckingTransactionsDAO();
        SavingsTransactionDAO savingsTransactionDAO = new SavingsTransactionDAO();

        AuthenticationService authenticationService = new AuthenticationService(userDAO);
        UserService userService = new UserService(checkingTransactionsDAO,savingsTransactionDAO,checkingAccountDAO,savingsAccountDAO,loanAppDAO);

        AuthenticationController authenticationController = new AuthenticationController(authenticationService);
        UserController userController = new UserController(userService);
        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();

        }).start(8080);

        app.routes(() -> {
         path("login", ()-> {
             get(authenticationController.userLogin);
         });
         path("user/{ID}", ()->{

             path("savingsaccount",()->{
                 get(userController::getSavingsAccountById);

             });
             path("checkingaccount",()->{

                 get(userController::getCheckingById);
             });
             path("loanapps",()->{
                 get(userController::getAllLoanAppsById);

             });


             path("savings-transactions", ()->{

                 get(userController::getSavingsTransactionsById);
             });
             path("checking-transactions", ()->{
                 get(userController::getCheckingTransactionsById);
             });
         });



        }

        );

    }
}
