import java.util.ArrayList;

/**
 * Created by francesco.rossato on 20/11/2017.
 */
public class Evaluator {
    public static String eval(String expression, ArrayList<String> subExp) {
        subExp = new ArrayList();
        for (int i = 0; i < expression.length(); i++)
            if (expression.charAt(i) == '(')
                for (int j = i + 1; expression.charAt(j) != ')'; j++)
                    subExp.add(Character.toString(expression.charAt(j)));
        for (String s : subExp)
            eval(s, subExp);
        String[] partial = expression.split("\\+");
        ArrayList<String[]> tokens = new ArrayList<>();
        for (String s : partial)
            tokens.add(s.split("-"));
        String out = "";
        for (String[] outer : tokens) {
            for (String inner : outer) {
                int fromIndex = 0;
                for(int i = 0; i < inner.length(); i++)
                    switch (inner.charAt(i)){
                        case '+':
                            int j = i;
                            while(inner.charAt(j) >= 0 && inner.charAt(j) <= 9)
                                j++;
                            out += Integer.parseInt(inner.substring(fromIndex, i)) + Integer.parseInt(inner.substring(i+1, j+1));
                    }
            }
        }
    }
}
