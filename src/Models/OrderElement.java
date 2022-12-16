package Models;

import DatabaseConfiguration.PostgresConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderElement {
    private PostgresConnection connection;

    public OrderElement(PostgresConnection connection) {
        this.connection = connection;
    }

    public void ShowOrdersStructure(int nr) throws SQLException {
        // Išspausinda visą lentelę "Uzsakymo elementas"
        PreparedStatement statement = connection.GetConnection().prepareStatement
            ("SELECT * FROM \"Uzsakymo elementas\" WHERE uzsakymo_nr = ?");
        statement.setInt(1, nr);
        ResultSet resultSet = statement.executeQuery();

        // Pagal prekės kodą įterpia pavadinimą, kad būtų paprasčiau matyti užsakymo sudėtį
        PreparedStatement statement1 = connection.GetConnection().prepareStatement("SELECT pavadinimas FROM Preke WHERE kodas = ?");

        while (resultSet.next()){
            int prekesNr = resultSet.getInt("prekes_eileje_nr");
            int uzsakymoNr = resultSet.getInt("uzsakymo_nr");
            int kodas = resultSet.getInt("prekes_kodas");

            statement1.setInt(1, kodas);
            ResultSet resultSet1 = statement1.executeQuery();
            resultSet1.next();
            String pavadinimas = resultSet1.getString("pavadinimas");

            int kiekis = resultSet.getInt("kiekis");

            System.out.printf("%-28d|%-16d|%-16d|%-28s|%-16d%n", prekesNr, uzsakymoNr, kodas, pavadinimas, kiekis);
        }
    }
}
