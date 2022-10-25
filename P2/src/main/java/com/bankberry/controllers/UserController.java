package com.bankberry.controllers;

import com.bankberry.entities.CheckingTransactions;
import com.bankberry.entities.LoanApplication;
import com.bankberry.entities.SavingsTransactions;
import com.bankberry.services.UserService;
import io.javalin.http.Context;



public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void getCheckingById(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("ID"));
        ctx.status(200);
        ctx.json(userService.getById(id));

    }
    public void getSavingsAccountById(Context ctx){
        int id = Integer.parseInt((ctx.pathParam("ID")));
        ctx.status(200);
        ctx.json(userService.getBySavingsId(id));

    }

    public void getCheckingTransactionsById(Context ctx){
        int id = Integer.parseInt((ctx.pathParam("ID")));
        ctx.status(200);
        ctx.json(userService.getByCheckingTransactionId(id));
    }
    public void getSavingsTransactionsById(Context ctx){
        int id = Integer.parseInt((ctx.pathParam("ID")));
        ctx.status(200);
        ctx.json(userService.getBySavingsTransactionID(id));
    }
    public void getAllLoanAppsById(Context ctx){
        int id = Integer.parseInt((ctx.pathParam("ID")));
        ctx.status(200);
        ctx.json(userService.getByAppId(id));
    }

    public void updateChecking(Context ctx){
        int id = Integer.parseInt((ctx.pathParam("ID")));
        double funds = Double.parseDouble((ctx.pathParam("update")));
        ctx.status(200);
        userService.updateChecking(id, funds);
    }

    public void updateSavings(Context ctx){
        int id = Integer.parseInt((ctx.pathParam("ID")));
        double funds = Double.parseDouble((ctx.pathParam("savingsupdate")));
        ctx.status(200);
        userService.updateSavings(id,funds);

    }
    public void createCheckingTransaction(Context ctx){
        CheckingTransactions checkingTransactions = ctx.bodyAsClass(CheckingTransactions.class);

        CheckingTransactions ckt = userService.createCheckingTransactions(checkingTransactions);
        ctx.json(ckt);
    }
    public void createSavingsTransaction(Context ctx){
        SavingsTransactions savingsTransactions = ctx.bodyAsClass(SavingsTransactions.class);
        SavingsTransactions st = userService.createSavingsTransactions(savingsTransactions);
        ctx.json(st);
    }
    public void createLoanApp(Context ctx){
        LoanApplication loanApplication = ctx.bodyAsClass(LoanApplication.class);
        LoanApplication la = userService.createLoanApp(loanApplication);
        ctx.json(la);
    }

    public void updateEmail(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("ID"));
        String updatedInfo = ctx.pathParam("updatedInfoEmail");
        userService.updateEmail(updatedInfo, id);

    }

    public void newPassword(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("ID"));
        String updatedInfo = ctx.pathParam("updatedInfo");
        userService.updatePassword(updatedInfo,id);
    }

}
