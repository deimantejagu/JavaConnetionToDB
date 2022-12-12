package Tables;

import java.util.Scanner;
import DatabaseConfiguration.DbConnection;

public class Item {
    private DbConnection dbConnection;
    private static final Scanner input = new Scanner(System.in);

    public Item(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void CreateItem(String itemTitle, String category, float price){

    }

    public void ShowItems(){

    }

    public void UpdateItem(int code){
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

    public void DeleteItem(int code){

    }
}
