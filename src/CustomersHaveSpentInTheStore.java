import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersHaveSpentInTheStore {
    public void ShowHowMuchCustomersHaveSpentInTheStore(){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.ConnectToDb(Config.DatabaseName(), Config.DatabaseUser(), Config.DatabasePassword());

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pirkejuisleistupinigusuma");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                System.out.printf("Id:%d Suma:%s%n", resultSet.getLong("pirkejoid"),
                        resultSet.getString("suma"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
