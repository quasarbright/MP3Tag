import java.sql.*;

public class createDB {
    public static void main(String[] args) {

        try {
            Connection c = ConnectToDB.connection();
            Statement statement = c.createStatement();
            String sql = "create table song"+
                    "(id int primary key not null," +
                    "name text not null," +
                    "path text not null)";
            statement.executeUpdate(sql);
            statement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
