import DatabaseConfiguration.PostgresConnection;
import Helper.*;
import Models.*;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private static final Scanner input = new Scanner(System.in);
    private static int selection = 0;
    private static PostgresConnection connection;

    public App(PostgresConnection connection) {
        this.connection = connection;
    }

    public void Start() throws SQLException {
        Order order = new Order(connection);
        Customer customer = new Customer(connection);
        Item item = new Item(connection);
        OrderElement element = new OrderElement(connection);
        AppHelper app = new AppHelper();

        while (selection < 14){
            selection = input.nextInt();

            switch (selection) {
                case ProgramConstants.SHOW_ACTION_LIST:
                    PrintTableHelper.UserActions();
                    break;
                case ProgramConstants.CREATE_CUSTOMER:
                    app.CreateCustomer(customer);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.SHOW_CUSTOMER:
                    app.ShowCustomer(customer);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.UPDATE_CUSTOMER:
                    app.UpdateCustomer(customer);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.DELETE_CUSTOMER:
                    app.DeleteCustomer(customer);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.CREATE_ORDER:
                    app.CreateOrder(order, customer);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.SHOW_ORDER:
                    app.ShowOrder(order);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.UPDATE_ORDER:
                    app.UpdateOrder(order);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.DELETE_ORDER:
                    app.DeleteOrder(order);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.CREATE_ITEM:
                    app.CreateItem(item);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.SHOW_ITEM:
                    app.ShowItem(item);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.UPDATE_ITEM:
                    app.UpdateItem(item);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.DELETE_ITEM:
                    app.DeleteItem(item);
                    PrintTableHelper.ShowUserActions();
                    break;
                case ProgramConstants.SHOW_ORDER_STRUCTURE:
                    app.ShowOrderStructure(element, order);
                    break;
                case ProgramConstants.END_WORK:
                    System.out.println("Programa išsijungia...");
                    break;
            }
        }
    }
}
