package com.bankberry;

import com.bankberry.DAOS.*;
import com.bankberry.controllers.AuthenticationController;
import com.bankberry.controllers.UserController;
import com.bankberry.services.AuthenticationService;
import com.bankberry.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;

public class AppRunner {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        LoanAppDAO loanAppDAO = new LoanAppDAO();
        CheckingAccountDAO checkingAccountDAO = new CheckingAccountDAO();
        SavingsAccountDAO savingsAccountDAO = new SavingsAccountDAO();
        CheckingTransactionsDAO checkingTransactionsDAO = new CheckingTransactionsDAO();
        SavingsTransactionDAO savingsTransactionDAO = new SavingsTransactionDAO();

        AuthenticationService authenticationService = new AuthenticationService(userDAO);
        UserService userService = new UserService(checkingTransactionsDAO, savingsTransactionDAO, checkingAccountDAO,
                savingsAccountDAO, loanAppDAO, userDAO);

        AuthenticationController authenticationController = new AuthenticationController(authenticationService);
        UserController userController = new UserController(userService);
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("public/HTML", Location.CLASSPATH);

        }).start(8080);

        app.routes(() -> {
            path("login", () -> {
                post(authenticationController.userLogin);
            });
            path("user/{ID}", () -> {
                path("{password}", () -> {
                    put(userController::newPassword);
                });
                path("{email}", () -> {
                    patch(userController::updateEmail);
                });
                path("savingsaccount", () -> {
                    get(userController::getSavingsAccountById);

                    path("{savingsupdate}", () -> {
                        put(userController::updateSavings);
                    });

                });
                path("checkingaccount", () -> {

                    get(userController::getCheckingById);

                    path("{update}", () -> {
                        put(userController::updateChecking);
                    });
                });
                path("loanapps", () -> {
                    get(userController::getAllLoanAppsById);
                    post(userController::createLoanApp);
                });

                path("savings-transactions", () -> {
                    get(userController::getSavingsTransactionsById);
                    post(userController::createSavingsTransaction);
                });
                path("checking-transactions", () -> {
                    get(userController::getCheckingTransactionsById);
                    post(userController::createCheckingTransaction);
                });
            });

        }

        );

    }
}
