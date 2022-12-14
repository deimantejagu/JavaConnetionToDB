import DatabaseConfiguration.GetConnection;
import Helper.HelperMethods;
import Tables.Customer;
import Tables.Item;
import Tables.Order;
import Tables.OrderElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ProgramLoop {
    private static final Scanner input = new Scanner(System.in);
    private static int selection = 0;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static GetConnection connection;

    public ProgramLoop(GetConnection connection) {
        this.connection = connection;
    }

    public void ProgramWorking() throws SQLException {
        Order order = new Order(connection);
        Customer customer = new Customer(connection);
        Item item = new Item(connection);
        OrderElement elementas = new OrderElement(connection);

        while (selection < 14){
            selection = input.nextInt();

            switch (selection) {
                case 0:
                    HelperMethods.UserActions();
                    break;
                case 1:
                    String name;
                    String surname;
                    String phoneNumber;
                    String email;
                    String address;
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

                    customer.CreateCustomer(name, surname, phoneNumber, email, address);

                    HelperMethods.ShowUserActions();
                    break;
                case 2:
                    HelperMethods.DrawCustomerTable();
                    customer.ShowCustomers();
                    HelperMethods.DrawCustomersOneLine();

                    HelperMethods.ShowUserActions();
                    break;
                case 3:
                    int id;
                    try {
                        HelperMethods.DrawCustomerTable();
                        customer.ShowCustomers();
                        HelperMethods.DrawCustomersOneLine();
                        System.out.println("Įveskite pirkėjo ID, kurio informaciją norite atnaujinti: ");
                        id = Integer.parseInt(br.readLine());
                        System.out.println("Įveskite naują telefono numerį: ");
                        phoneNumber = br.readLine();
                        System.out.println("Įveskite naują el. paštą: ");
                        email = br.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    customer.UpdateCustomer(id, phoneNumber, email);

                    HelperMethods.ShowUserActions();
                    break;
                case 4:
                    System.out.println("Įveskite pirkėjo ID, kurį norite pašalinti: ");

                    try {
                        HelperMethods.DrawCustomerTable();
                        customer.ShowCustomers();
                        HelperMethods.DrawCustomersOneLine();
                        id = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    customer.DeleteCustomer(id);

                    HelperMethods.ShowUserActions();
                    break;
                case 5:
                    int duration;
                    String title;
                    int amount;
                    List<String> titles = new ArrayList<>();
                    List<Integer> amounts = new ArrayList<>();
                    try {
                        HelperMethods.DrawCustomerTable();
                        customer.ShowCustomers();
                        HelperMethods.DrawCustomersOneLine();
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

                    order.CreateOrder(id, duration, titles, amounts);

                    HelperMethods.ShowUserActions();
                    break;
                case 6:
                    HelperMethods.DrawOrderTable();
                    order.ShowOrders();
                    HelperMethods.DrawOrdersOneLine();

                    HelperMethods.ShowUserActions();
                    break;
                case 7:
                    String state;
                    int nr;
                    try {
                        HelperMethods.DrawOrderTable();
                        order.ShowOrders();
                        HelperMethods.DrawOrdersOneLine();

                        System.out.println("Pasirinkite užsakymo Nr., kurį norite atnaujinti: ");
                        nr = Integer.parseInt(br.readLine());
                        System.out.println("Įveskite užsakymo būseną: ");
                        state = br.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    order.UpdateOrdersState(state, nr);

                    HelperMethods.ShowUserActions();
                    break;
                case 8:
                    HelperMethods.DrawOrderTable();
                    order.ShowOrders();
                    HelperMethods.DrawOrdersOneLine();

                    System.out.println("Įveskite užsakymo Nr., kurį norite pašalinti: ");
                    try {
                        nr = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    order.DeleteOrder(nr);

                    HelperMethods.ShowUserActions();
                    break;
                case 9:
                    String category;
                    float price;
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

                    item.CreateItem(category, title, price);

                    HelperMethods.ShowUserActions();
                    break;
                case 10:
                    HelperMethods.DrawItemTable();
                    item.ShowItems();
                    HelperMethods.DrawItemsOneLine();

                    HelperMethods.ShowUserActions();
                    break;
                case 11:
                    int code;
                    try {
                        HelperMethods.DrawItemTable();
                        item.ShowItems();
                        HelperMethods.DrawItemsOneLine();

                        System.out.println("Įveskite prekės kodą, kurios informaciją norite atnaujinti: ");
                        code = Integer.parseInt(br.readLine());
                        System.out.println("Įveskite naują prekės pavadinimą: ");
                        title = br.readLine();
                        System.out.println("Įveskite naują prekės kainą: ");
                        price = Float.parseFloat(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    item.UpdateItem(code, title, price);

                    HelperMethods.ShowUserActions();
                    break;
                case 12:
                    HelperMethods.DrawItemTable();
                    item.ShowItems();
                    HelperMethods.DrawItemsOneLine();

                    System.out.println("Įveskite prekės kodą, kurią norite pašalinti: ");
                    try {
                        code = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    item.DeleteItem(code);

                    HelperMethods.ShowUserActions();
                    break;
                case 13:
                    HelperMethods.DrawOrderTable();
                    order.ShowOrders();
                    HelperMethods.DrawOrdersOneLine();

                    System.out.println("Įveskite užsakymo Nr., kurio sudėtį norite sužinoti ");
                    try {
                        nr = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    HelperMethods.DrawOrderElementTable();
                    elementas.ShowOrdersStructure(nr);
                    HelperMethods.DrawOrderElementOneLine();

                    HelperMethods.ShowUserActions();
                    break;
                case 14:
                    System.out.println("Programa išsijungia...");
                    break;
            }
        }
    }
}
