package com.bankberry.controllers;

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
}
