package com.bankberry;

import com.bankberry.DAOS.*;
import com.bankberry.controllers.AuthenticationController;
import com.bankberry.controllers.UserController;
import com.bankberry.services.AuthenticationService;
import com.bankberry.services.UserService;
import io.javalin.Javalin;


import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

public class AppRunner {
    public static void main(String[] args) {

        UserDAO userDAO= new UserDAO();
        LoanAppDAO loanAppDAO = new LoanAppDAO();
        CheckingAccountDAO checkingAccountDAO =new CheckingAccountDAO();
        SavingsAccountDAO savingsAccountDAO = new SavingsAccountDAO();
        CheckingTransactionsDAO checkingTransactionsDAO = new CheckingTransactionsDAO();
        SavingsTransactionDAO savingsTransactionDAO = new SavingsTransactionDAO();

        AuthenticationService authenticationService = new AuthenticationService(userDAO);
        UserService userService = new UserService(checkingTransactionsDAO,savingsTransactionDAO,checkingAccountDAO,savingsAccountDAO,loanAppDAO,userDAO);

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
             path("updatedInfoEmail", ()->{
                 post(userController::updateEmail);
             });
             path("updatedInfo",()->{
                post(userController::newPassword);
             });

             path("savingsaccount",()->{
                 get(userController::getSavingsAccountById);

                path("{savingsupdate}",()->{
                    post(userController::updateSavings);
                });

             });
             path("checkingaccount",()->{

                 get(userController::getCheckingById);

                    path("{update}", () ->{
                        post(userController::updateChecking);
                    });});
             path("loanapps",()->{
                 get(userController::getAllLoanAppsById);
                 post(userController::createLoanApp);
             });


             path("savings-transactions", ()->{
                 get(userController::getSavingsTransactionsById);
                 post(userController::createSavingsTransaction);
             });
             path("checking-transactions", ()->{
                 get(userController::getCheckingTransactionsById);
                 post(userController::createCheckingTransaction);
             });
         });



        }

        );

    }
}
