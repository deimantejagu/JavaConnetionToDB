import DatabaseConfiguration.GetConnection;
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
import java.util.Objects;
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
                    UserActions();
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

                    ShowUserActions();
                    break;
                case 2:
                    DrawCustomerTable();
                    customer.ShowCustomers();
                    DrawCustomersOneLine();

                    ShowUserActions();
                    break;
                case 3:
                    int id;
                    try {
                        DrawCustomerTable();
                        customer.ShowCustomers();
                        DrawCustomersOneLine();
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

                    ShowUserActions();
                    break;
                case 4:
                    System.out.println("Įveskite pirkėjo ID, kurį norite pašalinti: ");

                    try {
                        DrawCustomerTable();
                        customer.ShowCustomers();
                        DrawCustomersOneLine();
                        id = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    customer.DeleteCustomer(id);

                    ShowUserActions();
                    break;
                case 5:
                    int duration;
                    String title;
                    int amount;
                    List<String> titles = new ArrayList<>();
                    List<Integer> amounts = new ArrayList<>();
                    try {
                        DrawCustomerTable();
                        customer.ShowCustomers();
                        DrawCustomersOneLine();
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

                    ShowUserActions();
                    break;
                case 6:
                    DrawOrderTable();
                    order.ShowOrders();
                    DrawOrdersOneLine();

                    ShowUserActions();
                    break;
                case 7:
                    String state;
                    int nr;
                    try {
                        DrawOrderTable();
                        order.ShowOrders();
                        DrawOrdersOneLine();

                        System.out.println("Pasirinkite užsakymo Nr., kurį norite atnaujinti: ");
                        nr = Integer.parseInt(br.readLine());
                        System.out.println("Įveskite užsakymo būseną: ");
                        state = br.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    order.UpdateOrdersState(state, nr);

                    ShowUserActions();
                    break;
                case 8:
                    DrawOrderTable();
                    order.ShowOrders();
                    DrawOrdersOneLine();

                    System.out.println("Įveskite užsakymo Nr., kurį norite pašalinti: ");
                    try {
                        nr = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    order.DeleteOrder(nr);

                    ShowUserActions();
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

                    ShowUserActions();
                    break;
                case 10:
                    DrawItemTable();
                    item.ShowItems();
                    DrawItemsOneLine();

                    ShowUserActions();
                    break;
                case 11:
                    int code;
                    try {
                        DrawItemTable();
                        item.ShowItems();
                        DrawItemsOneLine();

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

                    ShowUserActions();
                    break;
                case 12:
                    DrawItemTable();
                    item.ShowItems();
                    DrawItemsOneLine();

                    System.out.println("Įveskite prekės kodą, kurią norite pašalinti: ");
                    try {
                        code = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    item.DeleteItem(code);

                    ShowUserActions();
                    break;
                case 13:
                    DrawOrderTable();
                    order.ShowOrders();
                    DrawOrdersOneLine();

                    System.out.println("Įveskite užsakymo Nr., kurio sudėtį norite sužinoti ");
                    try {
                        nr = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.printf("%-26s%-18s%-18s%-30s%-18s%n", "Prekės Nr. eilėje", "Užsakymo Nr.", "Prekės Kodas", "Pavadinimas", "Kiekis");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    elementas.ShowOrdersStructure(nr);
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                    ShowUserActions();
                    break;
                case 14:
                    System.out.println("Programa išsijungia...");
                    break;
            }
        }
    }

    public void UserActions(){
        System.out.println(
            "Pasirinkite veiksmą, kurį norite atlikti:\n" +
                "\t0. Pamatyti veiksmų sąrašą\n" +
                "\t1. Užregistruoti naują pirkėją\n" +
                "\t2. Pamatyti pirkėjų sąrašą\n" +
                "\t3. Atnaujinti informaciją apie pirkėją\n" +
                "\t4. Pašalinti pirkėją\n" +
                "\t5. Sukurti naują užsakymą\n" +
                "\t6. Pamatyti užsakymų sąrašą\n" +
                "\t7. Atnaujinti užsakymo būseną\n" +
                "\t8. Pašalinti užsakymą\n" +
                "\t9. Pridėti naujas prekes\n" +
                "\t10. Pamatyti prekių sąrašą\n" +
                "\t11. Atnaujinti informaciją apie prekę\n" +
                "\t12. Pašalinti prekę\n" +
                "\t13. Sužinoti, kas sudaro užsakymą\n" +
                "\t14. Baigti darbą"
        );
    }

    private static void ShowUserActions(){
        ProgramLoop programLoop = new ProgramLoop(connection);
        System.out.println("Ar norite pamatyti veiksmų sąrašą? (taip/ne)");
        Scanner data = new Scanner(System.in);
        String option = data.nextLine();
        if(Objects.equals(option, "taip")){
            programLoop.UserActions();
        }
    }

    private static void DrawCustomerTable(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-18s%-30s%-30s%-30s%-30s%-30s%n", "ID", "Vardas", "Pavardė", "Tel. numeris", "El. paštas", "Adresas");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void DrawCustomersOneLine(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void DrawOrderTable(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-18s%-37s%-28s%-20s%-14s%n", "Nr.", "Užsakymo data", "Pristatymo trukmė", "Būsena", "Pirkėjo ID");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

    private static void DrawOrdersOneLine(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

    private static void DrawItemTable(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("%-18s%-28s%-28s%-14s%n", "Prekės kodas", "Kategorija", "Pavadinimas", "Kaina");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private static void DrawItemsOneLine(){
        System.out.println("-------------------------------------------------------------------------------------");
    }
}
