package Tables;

import DatabaseConfiguration.GetConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Order {
    private GetConnection connection;

    public Order(GetConnection connection) {
        this.connection = connection;
    }

    public void CreateOrder(int id, int duration, List<String> titles, List<Integer> amounts) throws SQLException {
        PreparedStatement orderStatement =
            connection.getConnection()
                .prepareStatement(
                        "INSERT INTO Uzsakymas (pristatymo_trukme, pirkejo_id) VALUES (?,?)"
                );

        PreparedStatement nrStatement =
            connection.getConnection()
                .prepareStatement(
                        "SELECT nr FROM Uzsakymas ORDER BY nr DESC LIMIT 1"
                );

        PreparedStatement itemStatement =
            connection.getConnection()
                .prepareStatement(
                        "SELECT kodas FROM Preke WHERE pavadinimas = ?"
                );

        PreparedStatement elementStatement =
            connection.getConnection()
                .prepareStatement(
                        "INSERT INTO \"Uzsakymo elementas\" (uzsakymo_nr, prekes_kodas, kiekis) VALUES (?,?,?)"
                );

        try {
            connection.getConnection().setAutoCommit(false);

            // Order statement
            orderStatement.setInt(1, duration);
            orderStatement.setInt(2, id);
            orderStatement.executeUpdate();
            //Nr statement
            ResultSet resultSet = nrStatement.executeQuery();
            resultSet.next();
            int nr = resultSet.getInt("nr");


            for (int i = 0; i < amounts.size(); i++) {
                elementStatement.setInt(1, nr);

                // Item Statement
                itemStatement.setString(1, titles.get(i));
                ResultSet resultSetcode = itemStatement.executeQuery();
                resultSetcode.next();
                int code = resultSetcode.getInt("kodas");

                // Element statement
                elementStatement.setInt(2, code);
                elementStatement.setInt(3, amounts.get(i));
                elementStatement.executeUpdate();
            }

            connection.getConnection().commit();
        } catch (SQLException e) {
            connection.getConnection().rollback();
            System.err.println("SQLException: " + e.getMessage());
            connection.getConnection().setAutoCommit(true);
        }
    }

    public void ShowOrders() throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM Uzsakymas ORDER BY nr");
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
