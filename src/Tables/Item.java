package Tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DatabaseConfiguration.GetConnection;

public class Item {
    private GetConnection connection;

    public Item(GetConnection connection) {
        this.connection = connection;
    }

    public void CreateItem(String category, String itemTitle, float price) throws SQLException {
        PreparedStatement statement =
            connection.getConnection()
                .prepareStatement(
                        "INSERT INTO Preke (kategorija, pavadinimas, kaina) VALUES (?,?,?)"
                );

        statement.setString(1, category);
        statement.setString(2, itemTitle);
        statement.setFloat(3, price);

        statement.executeUpdate();
    }

    public void ShowItems() throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM Preke");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            int kodas = resultSet.getInt("kodas");
            String kategorija = resultSet.getString("kategorija");
            String pavadinimas = resultSet.getString("pavadinimas");
            float kaina = resultSet.getFloat("kaina");

            System.out.printf("%-16d|%-26s|%-26s|%-12.2f%n", kodas, kategorija, pavadinimas, kaina);
        }
    }

    public void UpdateItem(int code){
    }

    public void DeleteItem(int code) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("DELETE FROM Preke WHERE kodas = ?");
        statement.setInt(1, code);
        statement.executeUpdate();
    }
}
