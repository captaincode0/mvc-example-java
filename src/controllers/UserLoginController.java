package controllers;

import entities.User;
import exception.UserLoginException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by captaincode on 12/29/16.
 */
public class UserLoginController extends Controller{
    //is not validated for SQL Injection
    public ControllerOperations logIn(User user){
        try{
            //if was connected successfully
            if(this.mySQLDatabaseController.connect()){
                //get the current connection to database
                Connection currentConnection = this.mySQLDatabaseController.getConnection();
                //set one prepared statement
                PreparedStatement preparedStatement = currentConnection.prepareStatement("select email, password from users where email=? and password=?");
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getPassword());

                ResultSet userResultSet = this.mySQLDatabaseHandler.getResultSet(preparedStatement);

                //if the data was gotten
                if(userResultSet != null){
                    preparedStatement.close();
                    userResultSet.close();
                    this.mySQLDatabaseController.close();
                    return ControllerOperations.USER_LOGIN_SUCCED;
                }
            }
            else
                throw new SQLException("Can't connect into database");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ControllerOperations.USER_LOGIN_FAILED;
    }
}
