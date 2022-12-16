import DatabaseConfiguration.PostgresConnection;
import Helper.PrintTableHelper;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PostgresConnection connection = new PostgresConnection();
        connection.SetConnection();

        App app = new App(connection);
        PrintTableHelper.UserActions();
        app.Start();
    }
}