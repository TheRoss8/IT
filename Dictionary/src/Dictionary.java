import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by francesco.rossato on 10/11/2017.
 */
public class Dictionary {
    private BinarySearchTree dictionary = new BinarySearchTree();
    private final String PATH;
    private static final int LETTER = 1;
    private static final int MEANING = 5;

    public Dictionary(String PATH) {
        this.PATH = PATH;
    }
    public void load()throws FileNotFoundException{
        File file = new File(PATH);
        Scanner in = new Scanner(file);
        while (in.hasNextLine()){
            String[] line = in.nextLine().split("\"");
            try {
                dictionary.add(new Lemma(line[LETTER], line[MEANING]));
            } catch (ArrayIndexOutOfBoundsException aor){
                System.err.println(aor.getMessage());
            }
        }
    }

    public Lemma search(String word){
        return (Lemma) BinarySearchTree.search(new Lemma(word, null), dictionary).getInfo();
    }
}