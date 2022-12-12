package Tables;

import DatabaseConfiguration.GetConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
    private GetConnection connection;

    public Customer(GetConnection connection) {
        this.connection = connection;
    }

    public void CreateCustomer(String name, String surname, String phoneNumber, String email, String address) throws SQLException {
        PreparedStatement statement =
            connection.getConnection()
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

    public void ShowCustomers() throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM Pirkejas");
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

    public void UpdateCustomer(int id){
    }

    public void DeleteCustomer(int id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("DELETE FROM Pirkejas WHERE id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
