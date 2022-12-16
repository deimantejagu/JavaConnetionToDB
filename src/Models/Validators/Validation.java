package Models.Validators;

public class Validation {
    public static boolean StringValidation(String input) {
        if (!input.matches("[a-zA-Z_]+")){
            System.out.println("Vardą turi sudaryti tik raidės!");
            return false;
        }
        return true;
    }

    public static boolean PhoneNumberValidation(String input) {
        if (!input.matches("^\\+[0-9]{1,3}[0-9]{4,14}(?:x.+)?$")){
            System.out.println("Blogas telefono numeris!");
            return false;
        }
        return true;
    }

    public static boolean EmailValidation(String input) {
        if (!input.matches("^(.+)@(\\S+) $.\n")){
            System.out.println("Blogas pašto adresas!");
            return false;
        }
        return true;
    }
}
