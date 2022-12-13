import DatabaseConfiguration.GetConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        GetConnection connection = new GetConnection();
        connection.setConnection();

        ProgramLoop programLoop = new ProgramLoop(connection);
        programLoop.UserActions();
        programLoop.ProgramWorking();
    }
}