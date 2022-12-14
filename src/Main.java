import DatabaseConfiguration.GetConnection;
import Helper.HelperMethods;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        GetConnection connection = new GetConnection();
        connection.setConnection();

        ProgramLoop programLoop = new ProgramLoop(connection);
        HelperMethods.UserActions();
        programLoop.ProgramWorking();
    }
}