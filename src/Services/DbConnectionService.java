package Services;

import java.sql.Connection;

public interface DbConnectionService {
     Connection getConnection();
     Connection setConnection();
}
