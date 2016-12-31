package model;

/**
 * Created by captaincode on 12/29/16.
 */
public class MySQLDatabaseConfigurator extends DatabaseConfigurator{
    public MySQLDatabaseConfigurator(String user, String password, String host, String database){
        super(user, password, host, database);
    }

    public MySQLDatabaseConfigurator(){
        super();
    }

    public String buildDSN(){
        return "jdbc:mysql://"+this.getHost()+"/"+this.getDatabase()+"?user=" + this.getUser() + "&password=" + this.getPassword();
    }
}
