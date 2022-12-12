import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
public class ProgramLoop {
    private static final Scanner input = new Scanner(System.in);
    private static final Scanner data = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int selection = 0;

    public static void ProgramWorking(){
         String option;

        while (selection < 11){
            selection = input.nextInt();

            switch (selection){
                case 0:
                    UserActions();
                    break;
                case 1:
                    UserAllOrders userAllOrders = new UserAllOrders();
                    System.out.println("Ar norite pamatyti informaciją apie pirkėjus? (taip/ne) ");
                    option = data.nextLine();

                    if(Objects.equals(option, "taip")){
                        // Isspausdina apie pirkėjus
                        userAllOrders.ShowUsers();
                    }

                    System.out.println("Įveskite pirkėjo ID, kurio užsakymus norite sužinoti: ");
                    int id = input.nextInt();
                    userAllOrders.ShowAllUserOrders(id);
                    //System.out.println(id);
                    ShowUserActions();
                    break;
                case 2:
                    System.out.println("Pirkėjai yra išleidę:\n");
                    ShowUserActions();
                    break;
                case 3:
                    System.out.println("Įvykdyti užsakymai:\n");
                    ShowUserActions();
                    break;
                case 4:
                    String phoneNumber = null;
                    String email = null;

                    System.out.println("Įveskite pirkėjo vardą: ");
                    String name = data.nextLine();
                    System.out.println("Įveskite pirkėjo pavardę: ");
                    String surname = data.nextLine();
                    System.out.println("Ar norite pridėti pirkėjo telefono numerį? (taip/ne)");
                    option = data.nextLine();

                    if(Objects.equals(option, "taip")){
                        System.out.println("Įveskite telefono numerį ");
                        phoneNumber = data.nextLine();
                    }

                    System.out.println("Ar norite pridėti pirkėjo elektroninį paštą? (taip/ne)");
                    option = data.nextLine();

                    if(Objects.equals(option, "taip")){
                        System.out.println("Įveskite elektroninį paštą ");
                        email = data.nextLine();
                    }

                    System.out.println("Įveskite pirkėjo adresą: ");
                    String address = data.nextLine();
                    System.out.println(name + " " + surname + " " + phoneNumber + " " + email + " " + address);
                    ShowUserActions();
                    break;
                case 5:
                    System.out.println("Įveskite pirkėjo vardą: ");
                    name = data.nextLine();
                    System.out.println("Įveskite pirkėjo pavardę: ");
                    surname = data.nextLine();
                    System.out.println("Įveskite pristatymo trukmę: ");
                    int duration;
                    try {
                        duration = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Įveskite prekes: ");
                    String item;
                    try {
                        item = br.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Įveskite prekės kiekį: ");
                    int amount = data.nextInt();

                    System.out.println(duration + " " + name + " " + surname + " " + item + " " + amount);
                    ShowUserActions();
                    break;
                case 6:
                    System.out.println("Įveskite prekės pavadinimą: ");
                    String title = data.nextLine();
                    System.out.println("Įveskite prekės kategoriją: ");
                    String category = data.nextLine();
                    System.out.println("Įveskite prekės kainą: ");
                    float price = data.nextFloat();

                    System.out.println(title + " " + category + " " + price);
                    ShowUserActions();
                    break;
                case 7:
                    System.out.println("Įveskite užsakymo ID, kurio būseną norite pakeisti: ");
                    try {
                        id = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Įveskite naują būseną: ");
                    String state;
                    try {
                        state = br.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(id + " " + state);
                    ShowUserActions();
                    break;
                case 8:
                    System.out.println("Įveskite užsakymo prekės pavadinimą, kurios kainą norite pakeisti: ");
                    title = data.nextLine();
                    System.out.println("Įveskite prekės kainą: ");
                    price = data.nextFloat();

                    System.out.println(title + " " + price);
                    ShowUserActions();
                    break;
                case 9:
                    System.out.println("Pasirinkite pirkėjo ID, kurį norite pašalinti: ");
                    id = data.nextInt();

                    System.out.println("Pirkėjas ID =" + " " + id + " " + "pašalintas");
                    ShowUserActions();
                    break;
                case 10:
                    System.out.println("Pasirinkite užsakymo Nr, kurį norite pašalinti: ");
                    id = data.nextInt();

                    System.out.println("Užsakymas Nr =" + " " + id + " " + "pašalintas");
                    ShowUserActions();
                    break;
                case 11:
                    System.out.println("Programa išsijungia...");
                    break;
            }
        }
    }

    public static void UserActions(){
        System.out.println(
            "Pasirinkite veiksmą, kurį norite atlikti:\n" +
                "\t0. Pamatyti veiksmų sąrašą\n" +
                "\t1. Sužinoti, visus vieno pirkėjo užsakymus\n" +
                "\t2. Sužinoti, kiek pirkėjai yra išleidę parduotuvėje\n" +
                "\t3. Sužinoti, visus įvykdytus užsakymus\n" +
                "\t4. Užregistruoti naują pirkeją\n" +
                "\t5. Sukurti naują užsakymą\n" +
                "\t6. Užregistruoti naujas prekes\n" +
                "\t7. Pakeisti prekės kainą\n" +
                "\t8. Pakeisti užsakymo būseną\n" +
                "\t9. Pašalinti pirkėją\n" +
                "\t10. Pašalinti užsakymą\n" +
                "\t11. Baigti darbą"
        );
    }

    private static void ShowUserActions(){
        System.out.println("Ar norite pamatyti veiksmų sąrašą? (taip/ne)");
        String option = data.nextLine();
        if(Objects.equals(option, "taip")){
            UserActions();
        }
    }
}
