package com.bankberry.controllers;

import com.bankberry.entities.User;
import com.bankberry.services.AuthenticationService;
import com.bankberry.services.UserService;
import io.javalin.http.Handler;

public class AuthenticationController {

  private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Handler userLogin = ctx->{
        User u = ctx.bodyAsClass(User.class);
        User authenticatedUser = authenticationService.userLogin(u.getEmail(),u.getPass());

        if(authenticatedUser!= null){
            ctx.status(200);
            ctx.json(authenticatedUser);
        }else{
            ctx.status(404);
            String message ="Incorrect credentials";
            ctx.json(message);
        }
    };
}
