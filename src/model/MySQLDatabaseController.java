package model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * Created by captaincode on 12/29/16.
 */
public class MySQLDatabaseController implements IDatabaseController {
    private Connection connection;
    private MySQLDatabaseConfigurator mySQLDatabaseConfigurator;

    public MySQLDatabaseController(MySQLDatabaseConfigurator mySQLDatabaseConfigurator) {
        this.mySQLDatabaseConfigurator = mySQLDatabaseConfigurator;
    }

    public MySQLDatabaseConfigurator getMySQLDatabaseConfigurator() {
        return this.mySQLDatabaseConfigurator;
    }

    public void setMySQLDatabaseConfigurator(MySQLDatabaseConfigurator mySQLDatabaseConfigurator) {
        this.mySQLDatabaseConfigurator = mySQLDatabaseConfigurator;
    }

    public Connection getConnection(){
        return this.connection;
    }

    @Override
    public boolean connect() {
        boolean connectionWasBuildedSuccessfully = false;

        try {
            //load the mysql driver
            Class.forName("com.mysql.jdbc.Driver");

            //open a connection using the JDBC
            this.connection = DriverManager.getConnection(this.mySQLDatabaseConfigurator.buildDSN());

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //check if the connection was builded successfully
            if (this.connection != null)
                connectionWasBuildedSuccessfully = !connectionWasBuildedSuccessfully;
        }
        return connectionWasBuildedSuccessfully;
    }

    @Override
    public boolean close() {
        boolean connectionWasClosed = false;

        try {
            //try to close the current connection
            this.connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //check if the connection was closed successfully
            if (this.connection == null)
                connectionWasClosed = !connectionWasClosed;
        }

        return connectionWasClosed;
    }
}
