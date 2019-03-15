import org.farng.mp3.TagNotFoundException;
import org.farng.mp3.id3.ID3v1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MP3Handler {
    public static String getTitle(String path) throws IOException {
        RandomAccessFile sourcefile = new RandomAccessFile(path, "r");
        ID3v1 id3;
        try {
            id3 = new ID3v1(sourcefile);
            return id3.getTitle();
        } catch (TagNotFoundException e) {
            File file = new File(path);
            String name = file.getName();
            if(name.length() > 4) {
                if(name.substring(name.length()-4).equals(".mp3")){
                    return name.substring(0, name.length()-4);
                }
            }
            return name;
        }
    }
}
