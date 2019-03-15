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

    public static void addSong(String path) {

    }

    public static void createDB() {
        DBHandler.executeUpdate("create table song"+
                "(id int primary key not null,"+
                "name text unique not null," +
                "path text unique not null)");
        DBHandler.executeUpdate("create table tag"+
                "(id int primary key not null," +
                "name text unique not null)");
        DBHandler.executeUpdate("create table playlist"+
                "(id int primary key not null," +
                "name text unique not null)");
        DBHandler.executeUpdate("create table song_tag"+
                "(id int primary key not null," +
                "song_id int not null," +
                "tag_id int not null)");
        DBHandler.executeUpdate("create table included_playlist_tag"+
                "(id int primary key not null," +
                "playlist_id int not null," +
                "tag_id int not null)");
        DBHandler.executeUpdate(("create table excluded_playlist_tag" +
                "(id int primary key not null," +
                "playlist_id int not null," +
                "tag_id int not null)"));
    }
}