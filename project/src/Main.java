import org.farng.mp3.TagException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(MP3Handler.getTitle("/Users/mdelmonaco/OneDrive/Music/10-13-18 additions/Astronauts - Reol.mp3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
