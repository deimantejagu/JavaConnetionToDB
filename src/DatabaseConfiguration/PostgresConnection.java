package DatabaseConfiguration;

import Contracts.IConnection;
import java.sql.Connection;

public class PostgresConnection implements IConnection {
    public Connection connection;

    @Override
    public Connection GetConnection() {

        return connection;
    }

    @Override
    public Connection SetConnection() {
        DbConnection dbConnection = new DbConnection();
        this.connection = dbConnection.ConnectToDb(Config.DatabaseName(), Config.DatabaseUser(), Config.DatabasePassword());

        return connection;
    }
}
