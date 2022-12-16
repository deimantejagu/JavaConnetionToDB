package Helper;

import Models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppHelper {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> titles = new ArrayList<>();
    List<Integer> amounts = new ArrayList<>();
    String name;
    String surname;
    String phoneNumber;
    String email;
    String address;
    String state;
    String category;
    int id;
    int duration;
    String title;
    int amount;
    int nr;
    int code;
    float price;

    /* ----------------------------- Customer ----------------------------- */
    public void CreateCustomer(Customer customer) throws SQLException {
        try {
            System.out.println("Įveskite vardą: ");
            name = br.readLine();
            System.out.println("Įveskite pavardę: ");
            surname = br.readLine();
            System.out.println("Įveskite telefono numerį: ");
            phoneNumber = br.readLine();
            System.out.println("Įveskite el. paštą: ");
            email = br.readLine();
            System.out.println("Įveskite adresą: ");
            address = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        customer.Create(name, surname, phoneNumber, email, address);
    }

    public void ShowCustomer(Customer customer) throws SQLException {
        PrintTableHelper.DrawCustomerTable();
        customer.Show();
        PrintTableHelper.DrawCustomersOneLine();
    }

    public void UpdateCustomer(Customer customer) throws SQLException {
        try {
            PrintTableHelper.DrawCustomerTable();
            customer.Show();
            PrintTableHelper.DrawCustomersOneLine();
            System.out.println("Įveskite pirkėjo ID, kurio informaciją norite atnaujinti: ");
            id = Integer.parseInt(br.readLine());
            System.out.println("Įveskite naują telefono numerį: ");
            phoneNumber = br.readLine();
            System.out.println("Įveskite naują el. paštą: ");
            email = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        customer.Update(id, phoneNumber, email);
    }

    public void DeleteCustomer(Customer customer) throws SQLException {
        System.out.println("Įveskite pirkėjo ID, kurį norite pašalinti: ");

        try {
            PrintTableHelper.DrawCustomerTable();
            customer.Show();
            PrintTableHelper.DrawCustomersOneLine();
            id = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        customer.Delete(id);
    }

    /* ----------------------------- Order ----------------------------- */

    public void CreateOrder(Order order, Customer customer) throws SQLException {
        try {
            PrintTableHelper.DrawCustomerTable();
            customer.Show();
            PrintTableHelper.DrawCustomersOneLine();
            System.out.println("Įveskite pirkėjo ID: ");
            id = Integer.parseInt(br.readLine());
            System.out.println("Įveskite pristatymo trukmę: ");
            duration = Integer.parseInt(br.readLine());
            System.out.println("Įveskite prekes ir jų kiekį: ");
            System.out.println("Kai baigsite vesti prekes, parašykite <Baigta>");

            while (true) {
                System.out.println("Pavadinimas: ");
                title = br.readLine();

                if ("Baigta".equalsIgnoreCase(title)) {
                    break;
                } else {
                    titles.add(title);
                }

                System.out.println("Kiekis: ");
                amount = Integer.parseInt(br.readLine());
                amounts.add(amount);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        order.create(id, duration, titles, amounts);
    }

    public void ShowOrder(Order order) throws SQLException {
        PrintTableHelper.DrawOrderTable();
        order.Show();
        PrintTableHelper.DrawOrdersOneLine();
    }

    public void UpdateOrder(Order order) throws SQLException {
        try {
            PrintTableHelper.DrawOrderTable();
            order.Show();
            PrintTableHelper.DrawOrdersOneLine();

            System.out.println("Pasirinkite užsakymo Nr., kurį norite atnaujinti: ");
            nr = Integer.parseInt(br.readLine());
            System.out.println("Įveskite užsakymo būseną: ");
            state = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        order.Update(state, nr);
    }

    public void DeleteOrder(Order order) throws SQLException {
        PrintTableHelper.DrawOrderTable();
        order.Show();
        PrintTableHelper.DrawOrdersOneLine();

        System.out.println("Įveskite užsakymo Nr., kurį norite pašalinti: ");
        try {
            nr = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        order.Delete(nr);
    }

    /* ----------------------------- Item ----------------------------- */

    public void CreateItem(Item item) throws SQLException {
        try {
            System.out.println("Įveskite prekės pavadinimą: ");
            title = br.readLine();
            System.out.println("Įveskite prekės kategoriją: ");
            category = br.readLine();
            System.out.println("Įveskite prekės kainą: ");
            price = Float.parseFloat(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        item.Create(category, title, price);

    }

    public void ShowItem(Item item) throws SQLException {
        PrintTableHelper.DrawItemTable();
        item.Show();
        PrintTableHelper.DrawItemsOneLine();
    }

    public void UpdateItem(Item item) throws SQLException {
        try {
            PrintTableHelper.DrawItemTable();
            item.Show();
            PrintTableHelper.DrawItemsOneLine();

            System.out.println("Įveskite prekės kodą, kurios informaciją norite atnaujinti: ");
            code = Integer.parseInt(br.readLine());
            System.out.println("Įveskite naują prekės pavadinimą: ");
            title = br.readLine();
            System.out.println("Įveskite naują prekės kainą: ");
            price = Float.parseFloat(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        item.Update(code, title, price);
    }

    public void DeleteItem(Item item) throws SQLException {
        PrintTableHelper.DrawItemTable();
        item.Show();
        PrintTableHelper.DrawItemsOneLine();

        System.out.println("Įveskite prekės kodą, kurią norite pašalinti: ");
        try {
            code = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* ----------------------------- Order element ----------------------------- */

    public void ShowOrderStructure(OrderElement element, Order order) throws SQLException {
        PrintTableHelper.DrawOrderTable();
        order.Show();
        PrintTableHelper.DrawOrdersOneLine();

        System.out.println("Įveskite užsakymo Nr., kurio sudėtį norite sužinoti ");
        try {
            nr = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintTableHelper.DrawOrderElementTable();
        element.ShowOrdersStructure(nr);
        PrintTableHelper.DrawOrderElementOneLine();

        PrintTableHelper.ShowUserActions();
    }
}
