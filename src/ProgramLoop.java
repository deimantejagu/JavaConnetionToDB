import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
public class ProgramLoop {
    private static final Scanner input = new Scanner(System.in);
    private static int selection = 0;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void ProgramWorking(){
        while (selection < 12){
            selection = input.nextInt();
            int option;

            switch (selection){
                case 0:
                    UserActions();
                    break;
                case 1:
                    System.out.println("Įveskite vardą: ");
                    System.out.println("Įveskite pavardę: ");
                    System.out.println("Įveskite telefono numerį: ");
                    System.out.println("Įveskite el. paštą: ");
                    System.out.println("Įveskite adresą: ");

                    ShowUserActions();
                    break;
                case 2:
                    ShowUserActions();
                    break;
                case 3:
                    System.out.println("Įveskite pirkėjo ID, kurio informaciją norite atnaujinti: ");
                    System.out.println(
                        "Pasirinkite, kokią informaciją norite atnaujinti:\n" +
                            "\t0. Telefono numerį\n" +
                            "\t1. El. paštą\n" +
                            "\t2. Adresą"
                    );

                    ShowUserActions();
                    break;
                case 4:
                    System.out.println("Įveskite pirkėjo ID, kurį norite pašalinti: ");

                    ShowUserActions();
                    break;
                case 5:
                    System.out.println("Įveskite pirkėjo ID: ");
                    System.out.println("Įveskite pristatymo trukmę: ");
                    System.out.println("Įveskite prekės pavadinimą: ");
                    System.out.println("Įveskite prekių kiekį: ");

                    ShowUserActions();
                    break;
                case 6:
                    System.out.println("Įveskite užsakymo būseną: ");

                    ShowUserActions();
                    break;
                case 7:
                    System.out.println("Įveskite užsakymo Nr., kurį norite pašalinti: ");

                    ShowUserActions();
                    break;
                case 8:
                    System.out.println("Įveskite prekės pavadinimą: ");
                    System.out.println("Įveskite prekės kategoriją: ");
                    System.out.println("Įveskite prekės kainą: ");

                    ShowUserActions();
                    break;
                case 9:

                    ShowUserActions();
                    break;
                case 10:
                    System.out.println("Įveskite prekės kodą, kurios informaciją norite atnaujinti: ");
                    System.out.println(
                        "Pasirinkite, kokią informaciją norite atnaujinti:\n" +
                            "\t0. Pavadinimą\n" +
                            "\t1. Kategoriją\n" +
                            "\t2. Kainą"
                    );

                    ShowUserActions();
                    break;
                case 11:
                    System.out.println("Įveskite prekės kodą, kurią norite pašalinti: ");

                    ShowUserActions();
                    break;
                case 12:
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
                "\t6. Atnaujinti užsakymo būseną\n" +
                "\t7. Pašalinti užsakymą\n" +
                "\t8. Pridėti naujas prekes\n" +
                "\t9. Pamatyti prekių sąrašą\n" +
                "\t10. Atnaujinti informaciją apie prekę\n" +
                "\t11. Pašalinti užsakymą\n" +
                "\t12. Baigti darbą"
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
