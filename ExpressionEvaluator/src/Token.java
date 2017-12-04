/**
 * Created by francesco.rossato on 20/11/2017.
 */
public class Token {
    private String type;
    private String valueRight;
    private String valueLeft;

    public String getType() {
        return type;
    }
    public String getValueRight() {
        return valueRight;
    }
    public String getValueLeft(){
        return  valueLeft;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setValueRight(String valueRight) {
        this.valueRight = valueRight;
    }
    public void setValueLeft(String valueLeft){
        this.valueLeft = valueLeft;
    }
}
