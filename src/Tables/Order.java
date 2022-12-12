package Tables;

import DatabaseConfiguration.DbConnection;

public class Order {
    private DbConnection dbConnection;

    public Order(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void CreateOrder(int id, int duration, String itemTitle, String amount){

    }

    public void ShowOrders(){

    }

    public void UpdateOrdersState(String state){

    }

    public void DeleteOrder(int nr){

    }
}
