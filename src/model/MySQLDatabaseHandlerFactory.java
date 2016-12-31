package model;

/**
 * T
 */
public class MySQLDatabaseHandlerFactory {
    private MySQLDatabaseHandler mySQLDatabaseHandler;

    public MySQLDatabaseHandlerFactory(){
        this.mySQLDatabaseHandler = null;
    }

    public MySQLDatabaseHandler factory(){
        if(this.mySQLDatabaseHandler == null){
            MySQLDatabaseConfigurator mySQLDatabaseConfigurator = new MySQLDatabaseConfigurator();
            mySQLDatabaseConfigurator.setUser("root");
            mySQLDatabaseConfigurator.setPassword("data.set");
            mySQLDatabaseConfigurator.setHost("localhost");
            mySQLDatabaseConfigurator.setDatabase("mvcexample");

            MySQLDatabaseController mySQLDatabaseController = new MySQLDatabaseController(mySQLDatabaseConfigurator);
            this.mySQLDatabaseHandler = new MySQLDatabaseHandler(mySQLDatabaseController);
        }

        return this.mySQLDatabaseHandler;
    }
}
