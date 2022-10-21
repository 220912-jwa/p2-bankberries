package com.bankberry.services;

import com.bankberry.DAOS.UserDAO;
import com.bankberry.entities.User;

public class AuthenticationService {

    private UserDAO userDAO;

    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User userLogin(String email, String password){
        User user = userDAO.getByEmail(email);
        if(user.getPass().equals(password)){
            System.out.println("Logged in");
            System.out.println(user);
        return user;
        }else{
            System.out.println("Incorrect credentials");
        }
        return null;

    }


}
