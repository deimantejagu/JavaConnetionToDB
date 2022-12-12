import DatabaseConfiguration.GetConnection;
import Tables.Customer;
import Tables.Item;
import Tables.Order;
import Tables.UzsakymoElementas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
public class ProgramLoop {
    private static final Scanner input = new Scanner(System.in);
    private static int selection = 0;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void ProgramWorking() throws SQLException {
        GetConnection connection = new GetConnection();
        connection.setConnection();

        Order order = new Order(connection);
        Customer customer = new Customer(connection);
        Item item = new Item(connection);
        UzsakymoElementas elementas = new UzsakymoElementas(connection);

        while (selection < 14){
            selection = input.nextInt();

            switch (selection){
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
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-18s%-30s%-30s%-30s%-30s%-30s%n", "ID", "Vardas", "Pavardė", "Tel. numeris", "El. paštas", "Adresas");
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    customer.ShowCustomers();
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

                    ShowUserActions();
                    break;
                case 3:
                    System.out.println("Įveskite pirkėjo ID, kurio informaciją norite atnaujinti: ");
                    /*System.out.println(
                        "Pasirinkite, kokią informaciją norite atnaujinti:\n" +
                            "\t0. Telefono numerį\n" +
                            "\t1. El. paštą\n" +
                            "\t2. Adresą"
                    );*/

                    int id;
                    try {
                        id = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(id);

                    ShowUserActions();
                    break;
                case 4:
                    System.out.println("Įveskite pirkėjo ID, kurį norite pašalinti: ");

                    try {
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
                    try {
                        System.out.println("Įveskite pirkėjo ID: ");
                        id = Integer.parseInt(br.readLine());
                        System.out.println("Įveskite pristatymo trukmę: ");
                        duration = Integer.parseInt(br.readLine());
                        System.out.println("Įveskite prekės pavadinimą: ");
                        title = br.readLine();
                        System.out.println("Įveskite prekių kiekį: ");
                        amount = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    order.CreateOrder(id, duration, title, amount);

                    ShowUserActions();
                    break;
                case 6:
                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-18s%-37s%-28s%-20s%-14s%n", "Nr.", "Užsakymo data", "Pristatymo trukmė", "Būsena", "Pirkėjo ID");
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    order.ShowOrders();
                    System.out.println("------------------------------------------------------------------------------------------------------------------");


                    ShowUserActions();
                    break;
                case 7:
                    String state;
                    int nr;
                    try {
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
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.printf("%-18s%-28s%-28s%-14s%n", "Prekės kodas", "Kategorija", "Pavadinimas", "Kaina");
                    System.out.println("-------------------------------------------------------------------------------------");
                    item.ShowItems();
                    System.out.println("-------------------------------------------------------------------------------------");

                    ShowUserActions();
                    break;
                case 11:
                    System.out.println("Įveskite prekės kodą, kurios informaciją norite atnaujinti: ");
                    /*System.out.println(
                        "Pasirinkite, kokią informaciją norite atnaujinti:\n" +
                            "\t0. Pavadinimą\n" +
                            "\t1. Kategoriją\n" +
                            "\t2. Kainą"
                    );*/

                    int code;
                    try {
                        code = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(code);

                    ShowUserActions();
                    break;
                case 12:
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

    public static void UserActions(){
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
                "\t13. Sužinoti, kas sudaro užsakymą}\n" +
                "\t14. Baigti darbą"
        );
    }

    private static void ShowUserActions(){
        System.out.println("Ar norite pamatyti veiksmų sąrašą? (taip/ne)");
        Scanner data = new Scanner(System.in);
        String option = data.nextLine();
        if(Objects.equals(option, "taip")){
            UserActions();
        }
    }
}
