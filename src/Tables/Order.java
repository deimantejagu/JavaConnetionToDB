package Tables;

import DatabaseConfiguration.GetConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    private GetConnection connection;

    public Order(GetConnection connection) {
        this.connection = connection;
    }

    public void CreateOrder(int id, int duration, String itemTitle, int amount) throws SQLException {
        PreparedStatement statement =
            connection.getConnection()
                .prepareStatement(
                        "INSERT INTO Uzsakymas (pristatymo_trukme, pirkejo_id) VALUES (?,?)"
                );

        statement.setInt(1, duration);
        statement.setInt(2, id);
        statement.executeUpdate();

        PreparedStatement statement2 = connection.getConnection().prepareStatement("SELECT kodas FROM Preke WHERE pavadinimas = ?");
        statement2.setString(1, itemTitle);
        ResultSet resultSet = statement2.executeQuery();
        resultSet.next();
        int code = resultSet.getInt("kodas");

        PreparedStatement statement4 = connection.getConnection().prepareStatement("SELECT COUNT(nr) FROM Uzsakymas");
        ResultSet resultSet4 = statement4.executeQuery();
        resultSet4.next();
        int nr = resultSet4.getInt(1);

        PreparedStatement statement1 =
            connection.getConnection()
                .prepareStatement(
                        "INSERT INTO Uzsakymo elementas (uzsakymo_nr, prekes_kodas, kiekis) VALUES (?,?,?)"
                );


        statement1.setInt(1, nr);
        statement1.setInt(2, code);
        statement1.setInt(3, amount);
        statement.executeUpdate();
    }

    public void ShowOrders() throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM Uzsakymas");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            int nr = resultSet.getInt("nr");
            String data = resultSet.getString("uzsakymo_data");
            String trukme = resultSet.getString("pristatymo_trukme");
            String busena = resultSet.getString("busena");
            int id = resultSet.getInt("pirkejo_id");

            System.out.printf("%-16d|%-35s|%-26s|%-26s|%-16d%n", nr, data, trukme, busena, id);
        }
    }

    public void UpdateOrdersState(String state, int nr) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("UPDATE Uzsakymas SET busena = ? WHERE nr = ?");
        statement.setString(1, state);
        statement.setInt(2, nr);
        statement.executeUpdate();
    }

    public void DeleteOrder(int nr) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("DELETE FROM Uzsakymas WHERE nr = ?");
        statement.setInt(1, nr);
        statement.executeUpdate();
    }
}
