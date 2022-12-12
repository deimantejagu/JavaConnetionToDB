package Tables;

import DatabaseConfiguration.GetConnection;

public class Order {
    private GetConnection connection;

    public Order(GetConnection connection) {
        this.connection = connection;
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
