import java.util.Objects;
import java.util.Scanner;
public class ProgramLoop {
    public static void ProgramWorking(){
        Scanner input = new Scanner(System.in);
        Scanner data = new Scanner(System.in);
        int selection = 0;
        int id = 0;

        while (selection < 11){
            selection = input.nextInt();

            switch (selection){
                case 0:
                    UserActions();
                    break;
                case 1:
                    System.out.println("Ar norite pamatyti informacija apie pirkėjus? (taip/ne) ");
                    String option1 = data.nextLine();

                    if(Objects.equals(option1, "taip")){
                        System.out.println("Informacija apie pirkėjus:\n");
                        // Isspausdina apie pirkėjus
                    }

                    System.out.println("Įveskite pirkėjo ID, kurio užsakymus norite sužinoti: ");
                    id = input.nextInt();
                    System.out.println(id);
                    break;
                case 2:
                    String category;

                    System.out.println("Ar norite pamatyti kategorijų sąrašą? (taip/ne) ");
                    String option = data.nextLine();

                    if(Objects.equals(option, "taip")){
                        System.out.println("Kategorijų sąrašas:\n");
                        // Isspausdina kategoriju sarasa

                        System.out.println("Pasirinkite kategoriją: ");
                        category = data.nextLine();
                        System.out.println(category);
                    } else if(Objects.equals(option, "ne")){
                        System.out.println("Įveskite norimą kategoriją: ");
                        category = data.nextLine();
                        System.out.println(category);
                    }
                    break;
                case 3:
                    System.out.println("Pirkėjai yra išleidę:\n");
                    break;
                case 4:
                    System.out.println("Įvykdyti užsakymai:\n");
                    break;
                case 5:
                    String phoneNumber = null;
                    String email = null;

                    System.out.println("Įveskite pirkėjo vardą: ");
                    String name = data.nextLine();
                    System.out.println("Įveskite pirkėjo pavardę: ");
                    String surname = data.nextLine();
                    System.out.println("Ar norite pridėti pirkėjo telefono numerį? (taip/ne)");
                    String option3 = data.nextLine();

                    if(Objects.equals(option3, "taip")){
                        System.out.println("Įveskite telefono numerį ");
                        phoneNumber = data.nextLine();
                    }

                    System.out.println("Ar norite pridėti pirkėjo elektroninį paštą? (taip/ne)");
                    option3 = data.nextLine();

                    if(Objects.equals(option3, "taip")){
                        System.out.println("Įveskite elektroninį paštą ");
                        email = data.nextLine();
                    }

                    System.out.println("Įveskite pirkėjo adresą: ");
                    String address = data.nextLine();
                    System.out.println(name + " " + surname + " " + phoneNumber + " " + email + " " + address);
                    break;
                case 6:
                    System.out.println("Įveskite pirkėjo vardą: ");
                    String nam = data.nextLine();
                    System.out.println("Įveskite pirkėjo pavardę: ");
                    String surnam = data.nextLine();
                    System.out.println("Įveskite pristatymo trukmę: ");
                    int duration = data.nextInt();
                    System.out.println("Įveskite prekes: ");
                    String item = data.nextLine();
                    System.out.println("Įveskite prekės kiekį: ");
                    int amount = data.nextInt();

                    System.out.println(duration + " " + nam + " " + surnam + " " + item + " " + amount);
                    break;
                case 7:
                    System.out.println("Įveskite prekės pavadinimą: ");
                    String title = data.nextLine();
                    System.out.println("Įveskite prekės kategoriją: ");
                    String categor = data.nextLine();
                    System.out.println("Įveskite prekės kainą: ");
                    float price = data.nextFloat();

                    System.out.println(title + " " + categor + " " + price);
                    break;
                case 8:
                    System.out.println("Darbas baigtas");
                    break;
                case 9:
                    System.out.println("9");
                    break;
                case 10:
                    System.out.println("10");
                    break;
                case 11:
                    System.out.println("11  ");
                    break;
            }
        }
    }

    public static void UserActions(){
        System.out.println(
            "Pasirinkite veiksmą, kurį norite atlikti:\n" +
                "\t0. Pamatyti veiksmų sąrašą\n" +
                "\t1. Sužinoti visus vieno pirkėjo užsakymus\n" +
                "\t2. Pamatyti prekes pagal kategoriją\n" +
                "\t3. Sužinoti, kiek pirkėjai yra išleidę parduotuvėje\n" +
                "\t4. Sužinoti, visus įvykdytus užsakymus\n" +
                "\t5. Užregistruoti naują pirkeją\n" +
                "\t6. Sukurti naują užsakymą\n" +
                "\t7. Užregistruoti naujas prekes\n" +
                "\t8. Redaguoti užsakymą\n" +
                "\t9. Pašalinti pirkėją\n" +
                "\t10. Pašalinti užsakymą\n" +
                "\t11. Baigti darbą"
        );
    }
}
