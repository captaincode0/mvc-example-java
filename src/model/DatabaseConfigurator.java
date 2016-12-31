package model;

/**
 * Created by captaincode on 12/29/16.
 */
public abstract class DatabaseConfigurator {
    private String user;
    private String password;
    private String host;
    private String database;

    public DatabaseConfigurator(String user, String password, String host, String database){
        this.user = user;
        this.password = password;
        this.host = host;
        this.database = database;
    }

    public DatabaseConfigurator(){}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
