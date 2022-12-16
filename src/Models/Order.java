package Models;

import DatabaseConfiguration.PostgresConnection;

import java.sql.*;
import java.util.List;

import static java.sql.Connection.TRANSACTION_SERIALIZABLE;

public class Order {
    private PostgresConnection connection;

    public Order(PostgresConnection connection) {
        this.connection = connection;
    }

    public void create(int id, int duration, List<String> titles, List<Integer> amounts) throws SQLException {
        // Sukuria naują užsakymą
        PreparedStatement orderStatement =
            connection.GetConnection()
                .prepareStatement(
                    "INSERT INTO Uzsakymas (pristatymo_trukme, pirkejo_id) VALUES (?,?)"
                );

        // Pasiima paskutinį sukurtą užsakymą, kad jam galėtumėm pridėti užsakymo elementus
        PreparedStatement nrStatement =
            connection.GetConnection()
                .prepareStatement(
                    "SELECT nr FROM Uzsakymas ORDER BY nr DESC LIMIT 1"
                );

        // Kadangi vartotojas įveda prekės pavadinimą, o užsakymo elemente prekė yra
        // aprašoma jos kodu, tai pagal pavadinimą suranda prekės kodą
        PreparedStatement itemStatement =
            connection.GetConnection()
                .prepareStatement(
                    "SELECT kodas FROM Preke WHERE pavadinimas = ?"
                );

        // Sukuria užsakymo elementą
        PreparedStatement elementStatement =
            connection.GetConnection()
                .prepareStatement(
                    "INSERT INTO \"Uzsakymo elementas\" (uzsakymo_nr, prekes_kodas, kiekis) VALUES (?,?,?)"
                );

        try {
            connection.GetConnection().setAutoCommit(false);
            connection.GetConnection().setTransactionIsolation(TRANSACTION_SERIALIZABLE);

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

            connection.GetConnection().commit();
        } catch (SQLException e) {
            connection.GetConnection().rollback();
            System.err.println("SQLException: " + e.getMessage());
            connection.GetConnection().setAutoCommit(true);
        }
    }

    public void Show() throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement("SELECT * FROM Uzsakymas ORDER BY nr");
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

    // [DEFAULT: 'Priimtas]', 'Vykdomas', 'Issiustas', 'Ivykdytas'
    public void Update(String state, int nr) throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement("UPDATE Uzsakymas SET busena = ? WHERE nr = ?");
        statement.setString(1, state);
        statement.setInt(2, nr);
        statement.executeUpdate();
    }

    public void Delete(int nr) throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement("DELETE FROM Uzsakymas WHERE nr = ?");
        statement.setInt(1, nr);
        statement.executeUpdate();
    }
}
