package model;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by captaincode on 12/29/16.
 */
public interface IMySQLQueryWriter {
    public void printMetaData(ResultSet resultSet) throws SQLException;
}
