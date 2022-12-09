public class Main {
    public static void main(String[] args) {
        DbConnection dbConnection = new DbConnection();
        dbConnection.ConnectToDb(Config.DatabaseName(), Config.DatabaseUser(), Config.DatabasePassword());

        ProgramLoop.UserActions();
        ProgramLoop.ProgramWorking();
    }
}