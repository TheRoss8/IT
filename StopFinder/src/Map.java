import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private LinkedList list;

    public Map(String path){
        load(path);
    }
    public Map(){
        list = new LinkedList();
    }

    public void load(String path){
        list = new LinkedList();
        try {
            Scanner in = new Scanner(new File(path));
            while(in.hasNextLine()){
                String[] line = in.nextLine().split(",");
                try {
                    list.add(new Stop(Integer.parseInt(line[0]), line[2], Double.parseDouble(line[4]), Double.parseDouble(line[5])));
                } catch (NumberFormatException e) {
                    System.err.println("Stop skipped");
                }
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File " + path + " not found");
        }
    }
    public Stop search(double latitude, double longitude){
        Stop nearest = null;
        double dist = Double.MAX_VALUE;
        for (Object s : list) {
            double newDist = Math.sqrt(Math.pow(((Stop) s).getLATITUDE() - latitude, 2) + Math.pow(((Stop) s).getLONGITUDE() - longitude, 2));
            if( newDist < dist) {
                dist = newDist;
                nearest = (Stop) s;
            }
        }
        return nearest;
    }

}
