package com.captaincode;

import java.util.Scanner;
import controllers.ControllerOperations;
import controllers.UserLoginController;
import entities.User;
import exception.UserLoginException;

public class CLIUserLogin {
    public static void main(String[] args) {
        Scanner systemInput = new Scanner(System.in);
        String email, password;

        //create the controller for this view
        UserLoginController userLoginController = new UserLoginController();

        System.out.println("[+] MVC example in Java with MySQL");
        boolean blankFields = false;

        //input the values and check if them are not blank
        do{
            System.out.print(">email: ");
            email = systemInput.nextLine();
            System.out.print(">password: ");
            password = systemInput.nextLine();

            blankFields = (email.equals("") || password.equals(""));

            if(blankFields)
                System.out.println("[+] Your email or password had a blank input");
        }while(blankFields);

        try{
            User user = new User(email, password);
            ControllerOperations controllerResponse = userLoginController.logIn(user);

            if(controllerResponse == ControllerOperations.USER_LOGIN_SUCCED)
                System.out.println("[+] Welcome to your system");
            else if(controllerResponse == ControllerOperations.USER_LOGIN_FAILED){
                System.out.println("[+] The user can't be founded on the database");
                throw new UserLoginException("The user can't be founded on the database");
            }
        }
        catch(UserLoginException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
