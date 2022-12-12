import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAllOrders {
    public void ShowUsers(){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.ConnectToDb(Config.DatabaseName(), Config.DatabaseUser(), Config.DatabasePassword());

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, vardas, pavarde FROM Pirkejas");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                System.out.printf("Id:%d Vardas:%s Pavarde:%s%n", resultSet.getLong("id"),
                        resultSet.getString("vardas"), resultSet.getString("pavarde"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowAllUserOrders(int id){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.ConnectToDb(Config.DatabaseName(), Config.DatabaseUser(), Config.DatabasePassword());

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT nr, uzsakymo_data, pristatymo_trukme, busena " +
                                                                            "FROM Uzsakymas WHERE pirkejo_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                System.out.printf("Uzsakymo Nr:%d Data:%s Ptistatymo trukme:%s Busena:%s%n", resultSet.getInt("nr"),
                        resultSet.getString("uzsakymo_data"), resultSet.getString("pristatymo_trukme"),
                        resultSet.getString("busena"));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
