
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by francesco.rossato on 10/11/2017.
 */
public class DictionaryTest {
    public static void main(String[] args) {
        final String PATH = "dictionary.csv";
        Dictionary dictionary = new Dictionary(PATH);
        Scanner in = new Scanner(System.in);
        try {
            dictionary.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(true){
            System.out.print("Input the word to search for: ");
            System.out.println("\n" + dictionary.search(in.nextLine()));
            System.out.print("\n\tExit? (s/n): ");
            if(in.nextLine().equalsIgnoreCase("s"))
                break;
        }
    }
}
