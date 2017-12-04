/**
 * Created by francesco.rossato on 24/11/2017.
 */
public class Eval {
    public String eval(String expression){
        for(int i = 0; i < expression.length(); i++)
            if(expression.charAt(i) == '(')
                for(int j = expression.length(); j > i; j--)
                    if(expression.charAt(j) == ')')
                        expression.replace(expression.substring(i, j+1), eval(expression.substring(i, j+1)));
        BinaryTree solve = new BinaryTree();
        int right = 0;
        int left = 0;
        int cnt = 0;
        boolean isLeft = true;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) > 0 && expression.charAt(i) < 10 && isLeft){
                right += expression.charAt(i) * Math.pow(10, cnt);
                cnt++;
            }
            if(isOperand(expression.charAt(i))){
                cnt = 0;
                isLeft = !isLeft;
            }
            if(expression.charAt(i) > 0 && expression.charAt(i) < 10 && !isLeft){
                left += expression.charAt(i) * Math.pow(10, cnt);
                cnt++;
            }
        }
    }

    private boolean isOperand(char token){
            return token == '+' || token == '-' || token == '*' || token == '/';
    }
}
