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

    public void CreateItem(String itemTitle, String category, float price){

    }

    public void ShowItems() throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM Preke");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.printf(
                "Kodas: %d Pavadinimas: %s Kategorija: %s Kaina: %f%n",
                resultSet.getInt("kodas"),
                resultSet.getString("pavadinimas"),
                resultSet.getString("kategorija"),
                resultSet.getFloat("kaina")
            );
        }
    }

    public void UpdateItem(int code){
    }

    public void DeleteItem(int code){

    }
}
