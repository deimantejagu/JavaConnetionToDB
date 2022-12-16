package Models;

import DatabaseConfiguration.PostgresConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private PostgresConnection connection;

    public Customer(PostgresConnection connection) {
        this.connection = connection;
    }

    public void Create(String name, String surname, String phoneNumber, String email, String address) throws SQLException {
        PreparedStatement statement =
            connection.GetConnection()
                .prepareStatement(
                    "INSERT INTO Pirkejas (vardas, pavarde, tel_numeris, el_pastas, adresas) VALUES (?,?,?,?,?)"
                );

        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setString(3, phoneNumber);
        statement.setString(4, email);
        statement.setString(5, address);

        statement.executeUpdate();
    }

    public void Show() throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement("SELECT * FROM Pirkejas ORDER BY id");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String vardas = resultSet.getString("vardas");
            String pavarde = resultSet.getString("pavarde");
            String telNumeris = resultSet.getString("tel_Numeris");
            String pastas = resultSet.getString("el_pastas");
            String adresas = resultSet.getString("adresas");

            System.out.printf("%-16d|%-28s|%-28s|%-28s|%-28s|%-28s%n", id, vardas, pavarde, telNumeris, pastas, adresas);
        }
    }

    public void Update(int id, String phoneNumber, String email) throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement
            ("UPDATE Pirkejas SET tel_numeris = ?, el_pastas = ? WHERE id = ?");
        statement.setString(1, phoneNumber);
        statement.setString(2, email);
        statement.setInt(3, id);
        statement.executeUpdate();
    }

    public void Delete(int id) throws SQLException {
        PreparedStatement statement = connection.GetConnection().prepareStatement("DELETE FROM Pirkejas WHERE id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
