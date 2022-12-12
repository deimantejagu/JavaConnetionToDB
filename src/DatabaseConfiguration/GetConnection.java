package DatabaseConfiguration;

import Services.DbConnectionService;
import java.sql.Connection;

public class GetConnection implements DbConnectionService {

    public Connection connection;

    @Override
    public Connection getConnection() {

        return connection;
    }

    @Override
    public Connection setConnection() {
        DbConnection dbConnection = new DbConnection();
        this.connection = dbConnection.ConnectToDb(Config.DatabaseName(), Config.DatabaseUser(), Config.DatabasePassword());

        return connection;
    }
}
