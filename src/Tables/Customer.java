package Tables;

import DatabaseConfiguration.DbConnection;

import java.util.Scanner;

public class Customer {
    private DbConnection dbConnection;
    private static final Scanner input = new Scanner(System.in);

    public Customer(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void CreateCustomer(String name, String surname, String phoneNumber, String email, String address){

    }

    public void ShowCustomers(){

    }

    public void UpdateCustomer(int id){
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        if(option == 0){
            System.out.println("0");
        } else if(option == 1){
            System.out.println("1");
        } else if(option == 2){
            System.out.println("2");
        }
    }

    public void DeleteCustomer(int id){

    }
}
