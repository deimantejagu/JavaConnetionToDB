package Tables;

import DatabaseConfiguration.GetConnection;

import java.util.Scanner;

public class Customer {
    private GetConnection connection;

    public Customer(GetConnection connection) {
        this.connection = connection;
    }

    public void CreateCustomer(String name, String surname, String phoneNumber, String email, String address){

    }

    public void ShowCustomers(){

    }

    public void UpdateCustomer(int id){
    }

    public void DeleteCustomer(int id){

    }
}
