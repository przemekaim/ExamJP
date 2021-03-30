import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reader {
    public static List<String> read() {
        try {
            return Files.readAllLines(Paths.get("baza.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
