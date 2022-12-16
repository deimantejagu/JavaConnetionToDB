package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DatabaseConfiguration.PostgresConnection;

public class Item {
    private PostgresConnection connection;

    public Item(PostgresConnection connection) {
        this.connection = connection;
    }

    public void Create(String category, String itemTitle, float price) throws SQLException {
        PreparedStatement statement =
            connection.GetConnection()
                .prepareStatement(
                    "INSERT INTO Preke (kategorija, pavadinimas, kaina) VALUES (?,?,?)"
                );

        statement.setString(1, category);
        statement.setString(2, itemTitle);
        statement.setFloat(3, price);

        statement.executeUpdate();
    }

    public void Show() throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement
            ("SELECT * FROM Preke ORDER BY kodas");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            int kodas = resultSet.getInt("kodas");
            String kategorija = resultSet.getString("kategorija");
            String pavadinimas = resultSet.getString("pavadinimas");
            float kaina = resultSet.getFloat("kaina");

            System.out.printf("%-16d|%-26s|%-26s|%-12.2f%n", kodas, kategorija, pavadinimas, kaina);
        }
    }

    public void Update(int code, String ttile, float price) throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement
            ("UPDATE Preke SET pavadinimas = ?, kaina = ? WHERE kodas = ?");
        statement.setString(1, ttile);
        statement.setFloat(2, price);
        statement.setInt(3, code);
        statement.executeUpdate();
    }

    public void Delete(int code) throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement("DELETE FROM Preke WHERE kodas = ?");
        statement.setInt(1, code);
        statement.executeUpdate();
    }
}
