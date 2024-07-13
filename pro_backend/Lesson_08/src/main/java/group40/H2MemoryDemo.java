package group40;

import java.sql.SQLException;

public class H2MemoryDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseManager manager = new DatabaseManager();
        manager.getConnection();
        manager.createTable();
        manager.getEmployee();
        manager.close();
    }
}
