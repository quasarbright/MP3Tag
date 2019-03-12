public class createDB {
    public static void main(String[] args) {

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
        DBHandler.executeUpdate(("create table excluded_playlist_tag"+
                "(id int primary key not null," +
                "playlist_id int not null," +
                "tag_id int not null)"));
    }
}
