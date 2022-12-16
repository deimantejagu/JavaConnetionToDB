package Contracts;

import java.sql.Connection;

public interface IConnection {
     Connection GetConnection();
     Connection SetConnection();
}
