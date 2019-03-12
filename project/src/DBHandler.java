import java.sql.*;

public class DBHandler {
    public static Connection connection() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void executeUpdate(String sql) {
        try {
            Connection c = connection();
            Statement statement = c.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}