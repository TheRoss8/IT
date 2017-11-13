/**
 * Created by francesco.rossato on 10/11/2017.
 */
public class Lemma implements Comparable{
    private final String WORD;
    private final String MEANING;

    public Lemma(String WORD, String MEANING) {
        this.WORD = WORD;
        this.MEANING = MEANING;
    }

    public String getWORD() {
        return WORD;
    }
    public String getMEANING() {
        return MEANING;
    }

    @Override
    public int compareTo(Object item){
        return this.WORD.compareTo(((Lemma) item).getWORD());
    }
    @Override
    public String toString() {
        return WORD + '\n' + MEANING;
    }

}
