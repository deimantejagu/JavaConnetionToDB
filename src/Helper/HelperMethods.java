package Helper;

import java.util.Objects;
import java.util.Scanner;

public class HelperMethods {
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
                "\t13. Sužinoti, kas sudaro užsakymą\n" +
                "\t14. Baigti darbą"
        );
    }

    public static void ShowUserActions(){
        System.out.println("Ar norite pamatyti veiksmų sąrašą? (taip/ne)");
        Scanner data = new Scanner(System.in);
        String option = data.nextLine();
        if(Objects.equals(option, "taip")){
            UserActions();
        }
    }

    public static void DrawCustomerTable(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-18s%-30s%-30s%-30s%-30s%-30s%n", "ID", "Vardas", "Pavardė", "Tel. numeris", "El. paštas", "Adresas");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void DrawCustomersOneLine(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void DrawOrderTable(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-18s%-37s%-28s%-20s%-14s%n", "Nr.", "Užsakymo data", "Pristatymo trukmė", "Būsena", "Pirkėjo ID");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

    public static void DrawOrdersOneLine(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

    public static void DrawItemTable(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("%-18s%-28s%-28s%-14s%n", "Prekės kodas", "Kategorija", "Pavadinimas", "Kaina");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void DrawItemsOneLine(){
        System.out.println("-------------------------------------------------------------------------------------");
    }
}
