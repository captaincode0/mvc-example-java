package controllers;

import model.MySQLDatabaseController;
import model.MySQLDatabaseHandler;
import model.MySQLDatabaseHandlerFactory;

/**
 * Created by captaincode on 12/29/16.
 */
public abstract class Controller {
    protected MySQLDatabaseHandler mySQLDatabaseHandler;
    protected MySQLDatabaseController mySQLDatabaseController;

    public Controller(){
        //factory the current handler
        MySQLDatabaseHandlerFactory mySQLDatabaseHandlerFactory = new MySQLDatabaseHandlerFactory();
        this.mySQLDatabaseHandler = mySQLDatabaseHandlerFactory.factory();

        //get the database controller to connect and disconnect into database
        this.mySQLDatabaseController = this.mySQLDatabaseHandler.getMySQLDatabaseController();
    }
}
