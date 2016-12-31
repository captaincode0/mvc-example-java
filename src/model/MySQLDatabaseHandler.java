package model;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @author: captaincode0.
 * @desc: this handler request one connection from mysql database created by the controller.
 */
public class MySQLDatabaseHandler implements IMySQLQueryWriter{
    private MySQLDatabaseController mySQLDatabaseController;

    public MySQLDatabaseHandler(MySQLDatabaseController mySQLDatabaseController){
        this.mySQLDatabaseController = mySQLDatabaseController;
    }

    public MySQLDatabaseController getMySQLDatabaseController(){
        return this.mySQLDatabaseController;
    }

    public void setMySQLDatabaseController(MySQLDatabaseController mySQLDatabaseController){
        this.mySQLDatabaseController = mySQLDatabaseController;
    }


    /**
    *  This method gets the result set from one select operation with one prepare statement
    */
    public ResultSet getResultSet(PreparedStatement preparedStatement){
        ResultSet tmpResultSet = null;
        try{
            tmpResultSet = preparedStatement.executeQuery();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return tmpResultSet;
    }

    @Override
    public void printMetaData(ResultSet resultSet) throws SQLException{
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println("        MySQL Meta Data ResultSet Printer");
        System.out.println("[+] Table name "+resultSetMetaData.getTableName(1));
        System.out.println("[+] Table columns number "+resultSetMetaData.getColumnCount());
        System.out.println("[+] Column name(s): ");
        for(int column=1; column<=resultSetMetaData.getColumnCount(); column++)
            System.out.println("\t-Column: "+column+", name: "+resultSetMetaData.getColumnName(column));
    }
}
