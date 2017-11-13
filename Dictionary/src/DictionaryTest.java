import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by francesco.rossato on 10/11/2017.
 */
public class DictionaryTest {
    public static void main(String[] args) {
        final String PATH = "dictionary.csv";
        Dictionary dictionary = new Dictionary(PATH);
        try {
            dictionary.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(dictionary.search("House"));
    }
}
