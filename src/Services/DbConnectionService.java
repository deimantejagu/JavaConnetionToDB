package Services;

import java.sql.Connection;

public interface DbConnectionService {
     Connection ConnectToDb(String dbname, String user, String pass);
}
